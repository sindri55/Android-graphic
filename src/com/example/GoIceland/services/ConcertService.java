package com.example.GoIceland.services;

import android.content.Context;
import com.example.GoIceland.models.Concert;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public interface ConcertService {
    public ArrayList<Concert> getConcertList();
}
