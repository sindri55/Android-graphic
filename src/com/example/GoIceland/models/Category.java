package com.example.GoIceland.models;

import android.app.Fragment;
import android.graphics.Bitmap;

/**
 * Created by Hannes on 9.4.2015.
 */
public class Category {
    private String m_Title;
    private Bitmap m_Image;
    private int m_FragmentId;

    public Category() {

    }

    public Category(String title, Bitmap image, int fragmentId) {
        this.m_Title = title;
        this.m_Image = image;
        this.m_FragmentId = fragmentId;
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

    public int getFragmentId() {
        return m_FragmentId;
    }

    public void setFragmentId(int fragmentId) {
        this.m_FragmentId = fragmentId;
    }
}
