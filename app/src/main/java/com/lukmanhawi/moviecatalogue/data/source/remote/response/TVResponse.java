package com.lukmanhawi.moviecatalogue.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class TVResponse implements Parcelable {
    private String tvId;
    private String title;
    private String date;
    private String description;
    private String rate;
    private String imagePath;

    public TVResponse(String tvId, String title, String date, String description, String rate, String imagePath) {
        this.tvId = tvId;
        this.title = title;
        this.description = description;
        this.rate = rate;
        this.date = date;
        this.imagePath = imagePath;
    }

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String tvId) {
        this.tvId = tvId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tvId);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.description);
        dest.writeString(this.rate);
        dest.writeString(this.imagePath);
    }

    public void readFromParcel(Parcel source) {
        this.tvId = source.readString();
        this.title = source.readString();
        this.date = source.readString();
        this.description = source.readString();
        this.rate = source.readString();
        this.imagePath = source.readString();
    }

    protected TVResponse(Parcel in) {
        this.tvId = in.readString();
        this.title = in.readString();
        this.date = in.readString();
        this.description = in.readString();
        this.rate = in.readString();
        this.imagePath = in.readString();
    }

    public static final Parcelable.Creator<TVResponse> CREATOR = new Parcelable.Creator<TVResponse>() {
        @Override
        public TVResponse createFromParcel(Parcel source) {
            return new TVResponse(source);
        }

        @Override
        public TVResponse[] newArray(int size) {
            return new TVResponse[size];
        }
    };
}
