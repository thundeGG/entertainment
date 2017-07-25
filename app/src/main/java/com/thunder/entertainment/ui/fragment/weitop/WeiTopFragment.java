package com.thunder.entertainment.ui.fragment.weitop;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.thunder.entertainment.R;
import com.thunder.entertainment.common.base.BaseFragment;
import com.thunder.entertainment.constant.ShapeConstant;
import com.thunder.entertainment.dao.ShapeManager;
import com.thunder.entertainment.dao.table.WeiTopModel;
import com.thunder.entertainment.ui.activity.weitop.ShapeActivity;
import com.thunder.entertainment.ui.adapter.WeiTopAdapter;
import com.thunder.entertainment.ui.listener.ScrollHidingListener;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by beibeizhu on 17/7/19.
 */

public class WeiTopFragment extends BaseFragment {


    @BindView(R.id.ll_text)
    LinearLayout llText;
    @BindView(R.id.ll_pic)
    LinearLayout llPic;
    @BindView(R.id.ll_video)
    LinearLayout llVideo;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.ll_title)
    LinearLayout ll_title;

    private ArrayList<String> mSelected;
    private List<WeiTopModel> weiTopModels;

    private WeiTopAdapter weiTopAdapter;

    private final int REQUEST_CODE_CHOOSE = 0;
    private final int REQUEST_CODE_TEXT = 1;
    private final int REQUEST_CODE_PIC = 2;
    private final int REQUEST_CODE_VIDEO = 3;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wei_top;
    }

    @Override
    protected void initView() {
        weiTopModels = new ArrayList<>();
        weiTopAdapter = new WeiTopAdapter(weiTopModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(weiTopAdapter);
    }

    @Override
    protected void initEvent() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                List<WeiTopModel> list = ShapeManager.getInstance().getList();
                if (list != null) {
                    weiTopAdapter.setNewData(list);
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });

        recyclerView.addOnScrollListener(new ScrollHidingListener() {
            @Override
            protected void onHide() {
                ll_title.setVisibility(View.GONE);
            }

            @Override
            protected void onShow() {
                ll_title.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected void initData() {
        List<WeiTopModel> list = ShapeManager.getInstance().getList();
        if (list != null) {
            weiTopAdapter.setNewData(list);
        }
    }

    @OnClick({R.id.ll_text, R.id.ll_pic, R.id.ll_video})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_text:
                Intent intent = new Intent(getActivity(), ShapeActivity.class);
                intent.putExtra(ShapeConstant.TYPE, ShapeConstant.TYPE_TEXT);
                startActivityForResult(intent, REQUEST_CODE_TEXT);
                break;
            case R.id.ll_pic:
                Matisse.from(this)
                        .choose(MimeType.of(MimeType.JPEG, MimeType.PNG))
                        .countable(true)
                        .capture(true)
                        .captureStrategy(
                                new CaptureStrategy(true, "com.thunder.entertainment.fileprovider"))
                        .maxSelectable(9)
//                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .theme(R.style.Matisse_MyStyle)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .forResult(REQUEST_CODE_CHOOSE);
                break;
            case R.id.ll_video:
                Toast.makeText(getActivity(),"待开发",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_CHOOSE:
                    mSelected = (ArrayList<String>) Matisse.obtainPathResult(data);
                    Log.d("Matisse", "mSelected: " + mSelected);
                    Intent intent = new Intent(getActivity(), ShapeActivity.class);
                    intent.putExtra(ShapeConstant.TYPE, ShapeConstant.TYPE_PIC);
                    intent.putStringArrayListExtra("data", mSelected);
                    startActivityForResult(intent, REQUEST_CODE_PIC);
                    break;
                case REQUEST_CODE_TEXT:
                    List<WeiTopModel> list = ShapeManager.getInstance().getList();
                    if (list != null) {
                        weiTopAdapter.setNewData(list);
                    }
                    break;
            }
        }
    }
}
