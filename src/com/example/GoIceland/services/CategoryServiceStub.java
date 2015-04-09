package com.example.GoIceland.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.GoIceland.R;
import com.example.GoIceland.enums.FragmentEnum;
import com.example.GoIceland.models.Category;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public class CategoryServiceStub implements CategoryService {
    private Context m_Context;

    public CategoryServiceStub(Context context) {
        m_Context = context;
    }

    public ArrayList<Category> getCategoryList() {
        ArrayList<Category> list = new ArrayList<Category>();

        Bitmap airplaneImage = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.ic_airplane);
        Bitmap brushImage = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.ic_brush);
        Bitmap footballImage = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.ic_football);
        Bitmap motorbikeImage = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.ic_motorbike);
        Bitmap mugImage = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.ic_mug);
        Bitmap musicImage = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.ic_music);



        list.add(new Category("Concerts", musicImage, FragmentEnum.ConcertFragment));
        list.add(new Category("Motor Sports", motorbikeImage, FragmentEnum.HomeFragment));
        list.add(new Category("Fly tours", airplaneImage, FragmentEnum.FlyToursFragment));
        list.add(new Category("Art Shows", brushImage, FragmentEnum.ArtShowsFragment));
        list.add(new Category("Bars", mugImage, FragmentEnum.BarsFragment));
        list.add(new Category("Sport Events", footballImage, FragmentEnum.SportEventFragment));

        return list;
    }
}
