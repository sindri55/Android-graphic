package com.example.GoIceland.enums;

/**
 * Created by Hannes on 9.4.2015.
 */
public class LocationEnum {
    public static final int Reykjavik = 0;
    public static final int Akureyri = 1;
    public static final int Isafjordur = 2;
    public static final int Bolungarvik = 3;
    public static final int Flatey = 4;

    public static String getString(int locationId) {
        switch (locationId) {
            case 0:
                return "Reykjavik";
            case 1:
                return "Akureyri";
            case 2:
                return "Isafjordur";
            case 3:
                return "Bolungarvik";
            case 4:
                return "Flatey";
            default:
                return "";
        }
    }
}
