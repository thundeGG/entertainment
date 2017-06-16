package com.thunder.entertainment.dao;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by beibeizhu on 17/6/16.
 */

@Entity
public class ChannelModel implements Parcelable {
    @Id(autoincrement = true)
    private Long id;
    //显示的文本
    @NotNull
    private String name;
    //对应的值
    @NotNull
    private String value;
    //当前的状态
    //0 没选择
    //1 选择
    @NotNull
    private int state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.value);
        dest.writeInt(this.state);
    }

    public ChannelModel() {
    }

    protected ChannelModel(Parcel in) {
        this.name = in.readString();
        this.value = in.readString();
        this.state = in.readInt();
    }

    @Generated(hash = 49983689)
    public ChannelModel(Long id, @NotNull String name, @NotNull String value, int state) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.state = state;
    }

    public static final Parcelable.Creator<ChannelModel> CREATOR = new Parcelable.Creator<ChannelModel>() {
        @Override
        public ChannelModel createFromParcel(Parcel source) {
            return new ChannelModel(source);
        }

        @Override
        public ChannelModel[] newArray(int size) {
            return new ChannelModel[size];
        }
    };

    @Override
    public String toString() {
        return "ChannelModel{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", state=" + state +
                '}';
    }
}
