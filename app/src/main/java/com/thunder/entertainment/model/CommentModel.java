package com.thunder.entertainment.model;

import java.util.List;

/**
 * Created by beibeizhu on 17/7/4.
 */

public class CommentModel {
    private String url;
    private String name;
    private String content;
    private String date;
    private String num;
    private List<CommentReplyModel> commentReplyList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public List<CommentReplyModel> getCommentReplyList() {
        return commentReplyList;
    }

    public void setCommentReplyList(List<CommentReplyModel> commentReplyList) {
        this.commentReplyList = commentReplyList;
    }
}
