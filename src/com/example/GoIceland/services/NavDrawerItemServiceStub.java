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
        items.add(new NavDrawerItem("Concerts", R.drawable.ic_home));
        items.add(new NavDrawerItem("Else", R.drawable.ic_home));
        items.add(new NavDrawerItem("Different", R.drawable.ic_home));

        return items;
    }
}
