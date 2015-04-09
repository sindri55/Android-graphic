package com.example.GoIceland.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.GoIceland.R;
import com.example.GoIceland.models.Concert;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public class ConcertServiceStub implements ConcertService {
    private Context m_Context;

    public ConcertServiceStub(Context context) {
        m_Context = context;
    }

    @Override
    public ArrayList<Concert> getConcertList() {
        ArrayList<Concert> list = new ArrayList<Concert>();

        Bitmap bubbi = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.bubbi);
        Bitmap megas = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.megas);
        Bitmap solid = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.solid);
        Bitmap raggi = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.raggi);



        list.add(new Concert("Name: Solid Hologram", "City: Reykjavík", "Location: Harpa, norðurljós", "Date: 29. maí 2015", "Time: 20:00", solid));
        list.add(new Concert("Name: Bubbi Morthens", "City: Reykjavík", "Location: Laugardalshöll", "Date: 14. maí 2015", "Time: 19:00", bubbi));
        list.add(new Concert("Name: Raggi Bjarna", "City: Reykjavík", "Location: Harpa, Norðurljós", "Date: 29 júní 2015", "Time: 20:00", raggi));
        list.add(new Concert("Name: Megas", "City: Hafnafjörður", "Location: Kaplakrika", "Date: 1 ágúst 2015", "Time: 22:00", megas));

        return list;
    }
}
