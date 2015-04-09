package com.example.GoIceland.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.GoIceland.R;
import com.example.GoIceland.activities.MainActivity;
import com.example.GoIceland.models.Category;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public class CategoryAdapter extends BaseAdapter {

    private Context m_Context;
    private ArrayList<Category> m_CategoryList;

    public CategoryAdapter(Context context, ArrayList<Category> categoryList) {
        m_Context = context;
        m_CategoryList = categoryList;
    }

    @Override
    public int getCount() {
        return m_CategoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return m_CategoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = LayoutInflater.from(m_Context);
            convertView = mInflater.inflate(R.layout.grid_category, null);
        }

        Typeface fontRegular = Typeface.createFromAsset(m_Context.getAssets(), "RobotoSlab-Regular.ttf");
        Typeface fontBold = Typeface.createFromAsset(m_Context.getAssets(), "RobotoSlab-Bold.ttf");
        Typeface fontThin = Typeface.createFromAsset(m_Context.getAssets(), "RobotoSlab-Thin.ttf");

        TextView txtTitle = (TextView) convertView.findViewById(R.id.category_title);
        ImageView imgImage = (ImageView) convertView.findViewById(R.id.category_image);

        txtTitle.setText(m_CategoryList.get(position).getTitle());
        txtTitle.setTypeface(fontBold);
        imgImage.setImageBitmap(m_CategoryList.get(position).getImage());

        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (m_Context instanceof MainActivity) {
                    int fragmentId = m_CategoryList.get(position).getFragmentId();
                    ((MainActivity) m_Context).displayView(fragmentId);
                }
            }
        });

        return convertView;
    }
}
