package com.example.GoIceland.models;

/**
 * Created by Hannes on 9.4.2015.
 */
public class NavDrawerItem {
    private String m_Title;
    private int m_Icon;

    public NavDrawerItem() {
    }

    public NavDrawerItem(String title, int icon) {
        this.m_Title = title;
        this.m_Icon = icon;
    }

    public String getTitle() {
        return m_Title;
    }

    public void setTitle(String title) {
        this.m_Title = title;
    }

    public int getIcon() {
        return m_Icon;
    }

    public void setIcon(int icon) {
        this.m_Icon = icon;
    }
}
