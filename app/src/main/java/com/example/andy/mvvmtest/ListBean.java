package com.example.andy.mvvmtest;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/**
 * Created by andy on 2017/8/13.
 */

public class ListBean implements Parcelable {
    private String Title;
    private String Summary;
    private int watchers;
    private int  stars;
    private int forks;
    public void onItemClick(View view)
    {

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Title);
        dest.writeString(this.Summary);
        dest.writeInt(this.watchers);
        dest.writeInt(this.stars);
        dest.writeInt(this.forks);
    }

    public ListBean() {
    }

    protected ListBean(Parcel in) {
        this.Title = in.readString();
        this.Summary = in.readString();
        this.watchers = in.readInt();
        this.stars = in.readInt();
        this.forks = in.readInt();
    }

    public static final Parcelable.Creator<ListBean> CREATOR = new Parcelable.Creator<ListBean>() {
        @Override
        public ListBean createFromParcel(Parcel source) {
            return new ListBean(source);
        }

        @Override
        public ListBean[] newArray(int size) {
            return new ListBean[size];
        }
    };
}
