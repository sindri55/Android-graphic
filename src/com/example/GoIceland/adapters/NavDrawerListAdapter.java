package com.example.GoIceland.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.GoIceland.R;
import com.example.GoIceland.models.NavDrawerItem;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public class NavDrawerListAdapter extends BaseAdapter {

    private Context m_Context;
    private ArrayList<NavDrawerItem> m_NavDrawerItems;

    public NavDrawerListAdapter(Context m_Context, ArrayList<NavDrawerItem> m_NavDrawerItems) {
        this.m_NavDrawerItems = m_NavDrawerItems;
        this.m_Context = m_Context;
    }

    @Override
    public int getCount() {
        return m_NavDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return m_NavDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) m_Context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.nav_list_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);

        imgIcon.setImageResource(m_NavDrawerItems.get(position).getIcon());
        txtTitle.setText(m_NavDrawerItems.get(position).getTitle());

        return convertView;
    }
}
