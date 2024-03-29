package com.example.GoIceland.models;

import android.graphics.Bitmap;

import com.example.GoIceland.enums.LocationEnum;

/**
 * Created by Hannes on 9.4.2015.
 */
public class Concert {

    private String m_Title;
    private int m_Location;
    private String m_Description;
    private String m_Date;
    private String m_Time;
    private Bitmap m_Image;

    public Concert() {
    }

    public Concert(String title,  int location, String description, String date, String time, Bitmap image) {
        this.m_Title = title;
        this.m_Location = location;
        this.m_Description = description;
        this.m_Date = date;
        this.m_Time = time;
        this.m_Image = image;
    }

    public String getTitle() {
        return m_Title;
    }

    public void setTitle(String title) {
        this.m_Title = title;
    }


    public String getDate() {
        return m_Date;
    }

    public void setDate(String date) {
        this.m_Date = date;
    }

    public String getTime() {
        return m_Time;
    }

    public void setTime(String time) {
        this.m_Time = time;
    }

    public Bitmap getImage() {
        return m_Image;
    }

    public void setImage(Bitmap image) {
        this.m_Image = image;
    }

    public String getDescription() {
        return m_Description;
    }

    public void setDescription(String description) {
        this.m_Description = description;
    }

    public int getLocationId() {
        return m_Location;
    }

    public String getLocation(){
        return LocationEnum.getString(m_Location);
    }

}
