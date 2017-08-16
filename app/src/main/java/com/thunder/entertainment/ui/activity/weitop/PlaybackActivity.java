package com.thunder.entertainment.ui.activity.weitop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.qiniu.pili.droid.shortvideo.PLShortVideoUploader;
import com.qiniu.pili.droid.shortvideo.PLUploadProgressListener;
import com.qiniu.pili.droid.shortvideo.PLUploadResultListener;
import com.qiniu.pili.droid.shortvideo.PLUploadSetting;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.utils.Auth;
import com.thunder.entertainment.common.utils.BitmapUtils;
import com.thunder.entertainment.common.utils.Config;
import com.thunder.entertainment.common.utils.StringUtils;
import com.thunder.entertainment.common.utils.ToastUtils;
import com.thunder.entertainment.constant.ShapeConstant;
import com.thunder.entertainment.dao.ShapeManager;
import com.thunder.entertainment.dao.table.WeiTopModel;
import com.thunder.entertainment.ui.weight.button.CircularProgressButton;

import org.greenrobot.eventbus.EventBus;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

import static com.thunder.entertainment.common.utils.Config.DOMAIN;

public class PlaybackActivity extends AppCompatActivity implements
        PLUploadResultListener,
        PLUploadProgressListener {
    private static final String MP4_PATH = "MP4_PATH";
    private static final String TAG = "PlaybackActivity";

    private JCVideoPlayerStandard mVideoPlayer;
    private CircularProgressButton mUploadBtn;
    private EditText mTitleEt;
    private PLShortVideoUploader mVideoUploadManager;
    private boolean mIsUpload = false;
    private String mVideoPath;
    private Auth auth;
    private String token;
    private WeiTopModel weiTopModel;

    public static void start(Activity activity, String mp4Path) {
        Intent intent = new Intent(activity, PlaybackActivity.class);
        intent.putExtra(MP4_PATH, mp4Path);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_playback);

        PLUploadSetting uploadSetting = new PLUploadSetting();
        try {
            auth = Auth.create(Config.AK, Config.SK);
            token = auth.uploadToken("thunder");
//            token = auth.uploadToken("thunder", null, 3600, new StringMap().putNotEmpty("name", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())), true);
            Log.i(TAG, "onCreate: token=  " + token);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mVideoUploadManager = new PLShortVideoUploader(getApplicationContext(), uploadSetting);
        mVideoUploadManager.setUploadProgressListener(this);
        mVideoUploadManager.setUploadResultListener(this);

        mVideoPlayer = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        mUploadBtn = (CircularProgressButton) findViewById(R.id.upload_btn);
        mTitleEt = (EditText) findViewById(R.id.et_title);

        mUploadBtn.setText(R.string.fabu);
        mUploadBtn.setOnClickListener(new UploadOnClickListener());
        mVideoPath = getIntent().getStringExtra(MP4_PATH);
        mVideoPlayer.setUp(mVideoPath, JCVideoPlayerStandard.CURRENT_STATE_NORMAL, "");
        mVideoPlayer.widthRatio = 1;
        mVideoPlayer.heightRatio = 1;
        mVideoPlayer.backButton.setVisibility(View.GONE);
        mVideoPlayer.setAllControlsVisible(View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE);

        Bitmap bitmap = BitmapUtils.getLocalVideoBitmap(mVideoPath);//获取第一帧图片
        mVideoPlayer.thumbImageView.setImageBitmap(bitmap);

        mVideoPlayer.startButton.performClick();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }


    public class UploadOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String title = mTitleEt.getText().toString();
            if (StringUtils.isEmpty(title)) {
                ToastUtils.s(PlaybackActivity.this, "请输入标题");
                return;
            }
            int progress = mUploadBtn.getProgress();
            if (progress == 100) {
            } else {
                if (!mIsUpload) {
                    mVideoUploadManager.startUpload(mVideoPath, token);
//                mUploadBtn.setText(R.string.cancel_upload);
                    mIsUpload = true;
                } else {
                    mVideoUploadManager.cancelUpload();
                    mUploadBtn.setText(R.string.upload);
                    mIsUpload = false;
                }
            }
        }
    }

    @Override
    public void onUploadProgress(String fileName, double percent) {
        mUploadBtn.setProgress((int) (percent * 100));
    }

//    public void copyToClipboard(String filePath) {
//        ClipData clipData = ClipData.newPlainText("VideoFilePath", filePath);
//        ClipboardManager clipboardManager = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
//        clipboardManager.setPrimaryClip(clipData);
//    }

    @Override
    public void onUploadVideoSuccess(String fileName) {
        String filePath = "http://" + DOMAIN + "/" + fileName;
        String title = mTitleEt.getText().toString();
        weiTopModel = new WeiTopModel();
        weiTopModel.setAuthor_name("张雷");
        weiTopModel.setAuthor_url("http://img1.imgtn.bdimg.com/it/u=3777017146,3311513479&fm=214&gp=0.jpg");
        weiTopModel.setContent(title);
        weiTopModel.setType(ShapeConstant.TYPE_VIDEO);
        weiTopModel.setVideo_url(filePath);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        weiTopModel.setCreate_time(simpleDateFormat.format(new Date()));
        ShapeManager.getInstance().addWeiTop(weiTopModel);
        EventBus.getDefault().post(weiTopModel);
        finish();
//        copyToClipboard(filePath);
//        ToastUtils.l(this, "文件上传成功，" + filePath + "已复制到粘贴板");
    }

    @Override
    public void onUploadVideoFailed(int statusCode, String error) {
        ToastUtils.l(this, "Upload failed, statusCode = " + statusCode + " error = " + error);
        mUploadBtn.setProgress(-1);
    }

    public void onClickBack(View v) {
        finish();
    }
}