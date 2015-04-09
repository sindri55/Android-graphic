package com.example.GoIceland.services;

import com.example.GoIceland.R;
import com.example.GoIceland.models.NavDrawerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannes on 9.4.2015.
 */
public class NavDrawerItemServiceStub implements NavDrawerItemService {

    @Override
    public ArrayList<NavDrawerItem> getNavDrawerItems() {
        ArrayList<NavDrawerItem> items = new ArrayList<NavDrawerItem>();

        items.add(new NavDrawerItem("Home", R.drawable.ic_home));
        items.add(new NavDrawerItem("Concerts", R.drawable.ic_music));
        items.add(new NavDrawerItem("Fly Tours", R.drawable.ic_airplane));
        items.add(new NavDrawerItem("Sport Events", R.drawable.ic_football));
        items.add(new NavDrawerItem("Motor Sports", R.drawable.ic_motorbike));
        items.add(new NavDrawerItem("Bars", R.drawable.ic_mug));
        items.add(new NavDrawerItem("Art Shows", R.drawable.ic_brush));

        return items;
    }
}
