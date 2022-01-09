package com.android_learn.aparatpro.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {

    private String id;
    private String title;
    private String icon;
    private String description;

    public Category(String id, String title, String icon, String description) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.description = description;
    }


    protected Category(Parcel in) {
        id = in.readString();
        title = in.readString();
        icon = in.readString();
        description = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(icon);
        dest.writeString(description);
    }
}
