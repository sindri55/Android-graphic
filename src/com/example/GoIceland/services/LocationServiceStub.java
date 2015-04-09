package com.example.GoIceland.services;

import com.example.GoIceland.enums.LocationEnum;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public class LocationServiceStub implements LocationService {
    @Override
    public ArrayList<String> getLocationList() {
        ArrayList<String> list = new ArrayList<String>();

        list.add(LocationEnum.Reykjavik, LocationEnum.getString(LocationEnum.Reykjavik));
        list.add(LocationEnum.Akureyri, LocationEnum.getString(LocationEnum.Akureyri));
        list.add(LocationEnum.Isafjordur, LocationEnum.getString(LocationEnum.Isafjordur));
        list.add(LocationEnum.Bolungarvik, LocationEnum.getString(LocationEnum.Bolungarvik));
        list.add(LocationEnum.Akureyri, LocationEnum.getString(LocationEnum.Flatey));

        return list;
    }
}
