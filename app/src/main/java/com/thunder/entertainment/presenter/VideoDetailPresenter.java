package com.thunder.entertainment.presenter;

import com.thunder.entertainment.common.base.RxPresenter;
import com.thunder.entertainment.common.net.RetrofitHelper;
import com.thunder.entertainment.common.net.RxUtils;
import com.thunder.entertainment.model.CommentModel;
import com.thunder.entertainment.model.CommentReplyModel;
import com.thunder.entertainment.model.kaiyan.VideoListBean;
import com.thunder.entertainment.presenter.contract.VideoDetailContract;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by beibeizhu on 17/7/4.
 */

public class VideoDetailPresenter extends RxPresenter implements VideoDetailContract.Presenter {

    private VideoDetailContract.View view;

    public VideoDetailPresenter(VideoDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void getRecommendList() {
        getVideoList("");
    }

    @Override
    public void getCommentList() {
        List<CommentModel> commentList = new ArrayList<>();

        CommentModel c1 = new CommentModel();
        c1.setUrl("http://img1.imgtn.bdimg.com/it/u=3777017146,3311513479&fm=214&gp=0.jpg");
        c1.setName("张雷");
        c1.setContent("真是太好看了!!!!!");
        c1.setDate("07-04 11:26");
        c1.setNum("99");

        List<CommentReplyModel> commentReplyList = new ArrayList<>();
        CommentReplyModel r1 = new CommentReplyModel();
        r1.setName("周泽冉");
        r1.setUrl("http://cdnq.duitang.com/uploads/item/201504/15/20150415H0546_YGatC.thumb.224_0.jpeg");
        r1.setContent("是嘛，我也觉得很好看！！！");
        r1.setDate("07-04 11:40");
        commentReplyList.add(r1);

        CommentReplyModel r2 = new CommentReplyModel();
        r2.setName("胡若洋");
        r2.setUrl("http://img1.touxiang.cn/uploads/20120802/02-064220_693.jpg");
        r2.setContent("你们什么眼光啊，这么难看还说好看");
        r2.setDate("07-04 11:50");
        commentReplyList.add(r2);

        CommentReplyModel r3 = new CommentReplyModel();
        r3.setName("林贝贝");
        r3.setUrl("http://wenwen.soso.com/p/20111118/20111118152120-18093601.jpg");
        r3.setContent("我也觉得还行啊，楼上什么眼光");
        r3.setDate("07-04 11:52");
        commentReplyList.add(r3);

        CommentReplyModel r4 = new CommentReplyModel();
        r4.setName("贝贝猪");
        r4.setUrl("http://img4.duitang.com/uploads/item/201306/25/20130625154432_yEedM.jpeg");
        r4.setContent("就是就是，2楼你真该是看看脑子了");
        r4.setDate("07-04 11:55");
        commentReplyList.add(r4);

        c1.setCommentReplyList(commentReplyList);
        commentList.add(c1);

        CommentModel c2 = new CommentModel();
        c2.setUrl("http://cdnq.duitang.com/uploads/item/201504/15/20150415H0546_YGatC.thumb.224_0.jpeg");
        c2.setName("周泽冉");
        c2.setContent("真是宇宙无敌地表最强的好看!!!!!");
        c2.setDate("07-04 11:56");
        c2.setNum("199");
        c2.setCommentReplyList(commentReplyList);
        commentList.add(c2);

        CommentModel c3 = new CommentModel();
        c3.setUrl("http://img1.touxiang.cn/uploads/20120802/02-064220_693.jpg");
        c3.setName("胡若洋");
        c3.setContent("勉勉强强说个好看吧!!!!");
        c3.setDate("07-04 12:26");
        c3.setNum("9");
        c3.setCommentReplyList(commentReplyList);
        commentList.add(c3);

        CommentModel c4 = new CommentModel();
        c4.setUrl("http://wenwen.soso.com/p/20111118/20111118152120-18093601.jpg");
        c4.setName("林贝贝");
        c4.setContent("真是没有比这还好看的了!!!!!");
        c4.setDate("07-04 13:26");
        c4.setNum("999");
        c4.setCommentReplyList(commentReplyList);
        commentList.add(c4);

        CommentModel c5 = new CommentModel();
        c5.setUrl("http://img4.duitang.com/uploads/item/201306/25/20130625154432_yEedM.jpeg");
        c5.setName("贝贝猪");
        c5.setContent("好看，要再看一万遍!!!!!");
        c5.setDate("07-04 14:26");
        c5.setNum("99999");
        c5.setCommentReplyList(commentReplyList);
        commentList.add(c5);

        view.showComment(commentList);
    }

    @Override
    public void getReplyList(CommentModel commentModel) {
        view.showReply(commentModel.getCommentReplyList());
    }

    private void getVideoList(String date) {
        Subscription subscribe = RetrofitHelper.getInstance().getKaiYanService().getVideoList(date)
                .compose(RxUtils.<VideoListBean>threadSwitcher())
                .subscribe(new Subscriber<VideoListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(VideoListBean videoListBean) {
                        view.showRecommend(videoListBean);
                    }
                });
        addSubscrebe(subscribe);
    }
}
