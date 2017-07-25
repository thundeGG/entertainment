package com.thunder.entertainment.dao.table;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by beibeizhu on 17/7/19.
 */
@Entity
public class WeiTopModel implements Parcelable, MultiItemEntity {
    @Id(autoincrement = true)
    private Long id;
    private String author_url;
    private String author_name;
    private String create_time;
    private String content;
    private String images;
    private String video_url;
    private int type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.author_url);
        dest.writeString(this.author_name);
        dest.writeString(this.create_time);
        dest.writeString(this.content);
        dest.writeString(this.images);
        dest.writeString(this.video_url);
        dest.writeInt(this.type);
    }

    public WeiTopModel() {
    }

    protected WeiTopModel(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.author_url = in.readString();
        this.author_name = in.readString();
        this.create_time = in.readString();
        this.content = in.readString();
        this.images = in.readString();
        this.video_url = in.readString();
        this.type = in.readInt();
    }

    @Generated(hash = 2095307820)
    public WeiTopModel(Long id, String author_url, String author_name,
                       String create_time, String content, String images, String video_url,
                       int type) {
        this.id = id;
        this.author_url = author_url;
        this.author_name = author_name;
        this.create_time = create_time;
        this.content = content;
        this.images = images;
        this.video_url = video_url;
        this.type = type;
    }

    public static final Creator<WeiTopModel> CREATOR = new Creator<WeiTopModel>() {
        @Override
        public WeiTopModel createFromParcel(Parcel source) {
            return new WeiTopModel(source);
        }

        @Override
        public WeiTopModel[] newArray(int size) {
            return new WeiTopModel[size];
        }
    };

    @Override
    public int getItemType() {
        return type;
    }
}
