package com.example.myapplication.pojo;

import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.myapplication.R;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Александр on 22.02.2015.
 */
public class BookModel implements Parcelable {

    private int bookId;
    private String bookTitle;
    private String description;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public BookModel(int bookId, String bookTitle, String description, int image)
    {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.description = description;
        this.image = image;

    }
    public BookModel(Parcel in) {
        String[] data = new String[4];
        in.readStringArray(data);
        bookId = Integer.valueOf(data[0]);
        bookTitle = data[1];
        description = data[2];
        image = Integer.valueOf(data[3]);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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
        dest.writeStringArray(new String[]{"" + bookId, bookTitle, description,"" + image});
    }

    public static final Parcelable.Creator<BookModel> CREATOR = new Parcelable.Creator<BookModel>() {

        @Override
        public BookModel createFromParcel(Parcel source) {
            return new BookModel(source);
        }

        @Override
        public BookModel[] newArray(int size) {
            return new BookModel[size];
        }
    };
}
