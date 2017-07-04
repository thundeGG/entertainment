package com.thunder.entertainment.presenter.contract;

import com.thunder.entertainment.common.base.BasePresenter;
import com.thunder.entertainment.common.base.BaseView;
import com.thunder.entertainment.model.CommentModel;
import com.thunder.entertainment.model.CommentReplyModel;
import com.thunder.entertainment.model.kaiyan.VideoListBean;

import java.util.List;

/**
 * Created by beibeizhu on 17/7/4.
 */

public interface VideoDetailContract {
    interface View extends BaseView<VideoDetailContract.Presenter> {

        void showComment(List<CommentModel> commentModelList);

        void showReply(List<CommentReplyModel> commentReplyModels);

        void showRecommend(VideoListBean videoListBeanList);
    }

    interface Presenter extends BasePresenter {
        void getRecommendList();

        void getCommentList();

        void getReplyList(CommentModel commentModel);
    }
}
