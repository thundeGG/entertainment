package com.thunder.entertainment.ui.activity.weitop;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.base.BaseActivity;
import com.thunder.entertainment.constant.ShapeConstant;
import com.thunder.entertainment.dao.ShapeManager;
import com.thunder.entertainment.dao.table.WeiTopModel;
import com.thunder.entertainment.ui.adapter.ShapeImageAdapter;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by beibeizhu on 17/7/19.
 */

public class ShapeActivity extends BaseActivity {
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_release)
    TextView tvRelease;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.et_content)
    EditText etContent;

    private View footerView;
    private final int MAX = 9;


    private ShapeImageAdapter shapeImageAdapter;
    List<String> images;

    private final int REQUEST_CODE_CHOOSE = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activty_shape;
    }

    @Override
    protected void initView() {
        shapeImageAdapter = new ShapeImageAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(shapeImageAdapter);

        footerView = getLayoutInflater().inflate(R.layout.view_add_pic, null);
        shapeImageAdapter.setFooterViewAsFlow(true);

    }

    @Override
    protected void initEvent() {
        shapeImageAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.img_pic_del:
                        shapeImageAdapter.remove(position);
                        isShowFooterView();
                        break;
                }
            }
        });

        footerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int surplus = MAX - shapeImageAdapter.getData().size();
                Matisse.from(mContext)
                        .choose(MimeType.ofImage())
                        .countable(true)
                        .capture(true)
                        .captureStrategy(
                                new CaptureStrategy(true, "com.thunder.entertainment.fileprovider"))
                        .maxSelectable(surplus)
//                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .theme(R.style.Matisse_MyStyle)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .forResult(REQUEST_CODE_CHOOSE);
            }
        });
    }

    @Override
    protected void initData() {

        int type = getIntent().getIntExtra(ShapeConstant.TYPE, ShapeConstant.TYPE_TEXT);
        if (type != ShapeConstant.TYPE_TEXT) {
            images = getIntent().getStringArrayListExtra("data");
        }else{
            images = new ArrayList<>();
        }
        shapeImageAdapter.setNewData(images);
        isShowFooterView();
    }

    public void isShowFooterView() {
        shapeImageAdapter.removeAllFooterView();
        if (images.size() < 9) {
            shapeImageAdapter.addFooterView(footerView);
        }
        shapeImageAdapter.notifyDataSetChanged();
    }


    @OnClick({R.id.tv_cancel, R.id.tv_release})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                this.finish();
                break;
            case R.id.tv_release:
                addWeiTop();
                break;
        }
    }

    private void addWeiTop() {
        String content = etContent.getText().toString();
        if (TextUtils.isEmpty(content)) {
            toastStr("请输入新鲜事");
            return;
        }
        int size = shapeImageAdapter.getData().size();
        WeiTopModel weiTopModel = new WeiTopModel();
        weiTopModel.setAuthor_name("张雷");
        weiTopModel.setAuthor_url("http://img1.imgtn.bdimg.com/it/u=3777017146,3311513479&fm=214&gp=0.jpg");
        weiTopModel.setContent(content);
        if (size > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : shapeImageAdapter.getData()) {
                stringBuilder.append(s + ",");
            }
            String images = stringBuilder.toString();
            images = images.substring(0, images.length() - 1);
            weiTopModel.setImages(images);
            weiTopModel.setType(ShapeConstant.TYPE_PIC);
        } else {
            weiTopModel.setImages("");
            weiTopModel.setType(ShapeConstant.TYPE_TEXT);
        }
        weiTopModel.setVideo_url("");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        weiTopModel.setCreate_time(simpleDateFormat.format(new Date()));
        ShapeManager.getInstance().addWeiTop(weiTopModel);
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            List<String> seletedes = Matisse.obtainPathResult(data);
            shapeImageAdapter.addData(seletedes);
        } else {
            Log.d("Matisse", "****************fail ");
        }
        isShowFooterView();
    }
}
