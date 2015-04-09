package com.example.GoIceland.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.GoIceland.R;
import com.example.GoIceland.enums.FragmentEnum;
import com.example.GoIceland.fragments.ConcertFragment;
import com.example.GoIceland.fragments.HomeFragment;
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

        Bitmap image = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.concert);

        list.add(new Category("Concerts", image, FragmentEnum.ConcertFragment));
        list.add(new Category("Motor Sports", image, FragmentEnum.HomeFragment));
        /*list.add(new Category("Fly tours", image));
        list.add(new Category("Art Shows", image));
        list.add(new Category("Bars", image));
        list.add(new Category("Sport Events", image));
        list.add(new Category("Concerts", image));
        list.add(new Category("Motor Sports", image));
        list.add(new Category("Fly tours", image));
        list.add(new Category("Art Shows", image));
        list.add(new Category("Bars", image));
        list.add(new Category("Sport Events", image));
        list.add(new Category("Concerts", image));
        list.add(new Category("Motor Sports", image));
        list.add(new Category("Fly tours", image));
        list.add(new Category("Art Shows", image));
        list.add(new Category("Bars", image));
        list.add(new Category("Sport Events", image));*/

        return list;
    }
}
