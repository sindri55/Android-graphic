package com.example.GoIceland.services;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public class DateServiceStub implements DateService {

    @Override
    public ArrayList<String> getMonthList() {
        ArrayList<String> monthList = new ArrayList<String>();

        monthList.add("January");
        monthList.add("February");
        monthList.add("March");
        monthList.add("April");
        monthList.add("May");
        monthList.add("June");
        monthList.add("July");
        monthList.add("August");
        monthList.add("September");
        monthList.add("October");
        monthList.add("November");
        monthList.add("December");

        return monthList;
    }

    @Override
    public ArrayList<String> getDayList() {
        ArrayList<String> dayList = new ArrayList<String>();

        for (int i = 0; i < 30; i++) {
            dayList.add(String.valueOf(i + 1));
        }

        return dayList;
    }
}
