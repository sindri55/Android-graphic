package com.example.GoIceland.models;

import android.graphics.Bitmap;

/**
 * Created by Hannes on 9.4.2015.
 */
public class Category {
    private String m_Title;
    private Bitmap m_Image;

    public Category() {

    }

    public Category(String title, Bitmap image) {
        this.m_Title = title;
        this.m_Image = image;
    }

    public String getTitle() {
        return m_Title;
    }

    public void setTitle(String title) {
        this.m_Title = title;
    }

    public Bitmap getImage() {
        return m_Image;
    }

    public void setImage(Bitmap image) {
        this.m_Image = image;
    }
}
