package com.example.GoIceland.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.GoIceland.R;
import com.example.GoIceland.models.Concert;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public class ConcertAdapter extends BaseAdapter {

    private Context m_Context;
    private ArrayList<Concert> m_ConcertList;
    private LayoutInflater m_Inflater;

    public ConcertAdapter(Context context, ArrayList<Concert> concertList) {
        m_Context = context;
        m_ConcertList = concertList;
        m_Inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return m_ConcertList.size();
    }

    @Override
    public Object getItem(int position) {
        return m_ConcertList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = LayoutInflater.from(m_Context);
            convertView = mInflater.inflate(R.layout.grid_concert, null);
        }

        ImageView imgImage = (ImageView) convertView.findViewById(R.id.concert_image);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.concert_title);
        TextView txtDescription = (TextView) convertView.findViewById(R.id.concert_description);

        txtTitle.setText(m_ConcertList.get(position).getTitle());
        imgImage.setImageBitmap(m_ConcertList.get(position).getImage());
        txtDescription.setText(m_ConcertList.get(position).getDescription());

        return convertView;
    }
}
