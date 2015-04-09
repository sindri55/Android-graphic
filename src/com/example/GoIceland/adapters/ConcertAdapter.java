package com.example.GoIceland.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.GoIceland.R;
import com.example.GoIceland.animations.SlideAnimationListener;
import com.example.GoIceland.models.Concert;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public class ConcertAdapter extends BaseAdapter {

    private Context m_Context;
    private ArrayList<Concert> m_ConcertList;

    public ConcertAdapter(Context context, ArrayList<Concert> concertList) {
        m_Context = context;
        m_ConcertList = concertList;
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

        LinearLayout concertContainer = (LinearLayout) convertView.findViewById(R.id.concert_container);
        concertContainer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ViewGroup parent = (ViewGroup) v.getParent();
                LinearLayout detailsContainer = (LinearLayout) parent.findViewById(R.id.concert_details_container);

                if (detailsContainer.getVisibility() == View.VISIBLE) {
                    Animation slideUp = AnimationUtils.loadAnimation(detailsContainer.getContext(), R.anim.slide_up);
                    slideUp.setAnimationListener(new SlideAnimationListener(detailsContainer, true));
                    detailsContainer.startAnimation(slideUp);
                } else {
                    detailsContainer.setVisibility(View.VISIBLE);
                    Animation slideDown = AnimationUtils.loadAnimation(detailsContainer.getContext(), R.anim.slide_down);
                    slideDown.setAnimationListener(new SlideAnimationListener(detailsContainer, false));
                    detailsContainer.startAnimation(slideDown);
                }
            }
        });

        return convertView;
    }
}
