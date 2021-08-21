package com.lukmanhawi.moviecatalogue.data.source.local;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieEntity implements Parcelable {
    private String movieId;
    private String title;
    private String date;
    private String description;
    private String rate;
    private String imagePath;

    public MovieEntity(String movieId, String title, String date, String description, String rate, String imagePath) {
        this.movieId = movieId;
        this.title = title;
        this.date = date;
        this.description = description;
        this.rate = rate;
        this.imagePath = imagePath;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
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
        dest.writeString(this.movieId);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.description);
        dest.writeString(this.rate);
        dest.writeString(this.imagePath);
    }

    public void readFromParcel(Parcel source) {
        this.movieId = source.readString();
        this.title = source.readString();
        this.date = source.readString();
        this.description = source.readString();
        this.rate = source.readString();
        this.imagePath = source.readString();
    }

    protected MovieEntity(Parcel in) {
        this.movieId = in.readString();
        this.title = in.readString();
        this.date = in.readString();
        this.description = in.readString();
        this.rate = in.readString();
        this.imagePath = in.readString();
    }

    public static final Parcelable.Creator<MovieEntity> CREATOR = new Parcelable.Creator<MovieEntity>() {
        @Override
        public MovieEntity createFromParcel(Parcel source) {
            return new MovieEntity(source);
        }

        @Override
        public MovieEntity[] newArray(int size) {
            return new MovieEntity[size];
        }
    };
}
