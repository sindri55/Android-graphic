package com.example.GoIceland.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.GoIceland.R;
import com.example.GoIceland.enums.LocationEnum;
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



        list.add(new Concert("Solid Hologram", LocationEnum.Reykjavik, "Harpa, norðurljós", "29. maí 2015", "20:00", solid));
        list.add(new Concert("Bubbi Morthens", LocationEnum.Reykjavik, "Laugardalshöll", "14. maí 2015", "19:00", bubbi));
        list.add(new Concert("Raggi Bjarna",  LocationEnum.Bolungarvik, "Harpa, Norðurljós", "29 júní 2015", "20:00", raggi));
        list.add(new Concert("Megas", LocationEnum.Flatey, "Kaplakrika", "1 ágúst 2015", "22:00", megas));

        return list;
    }
}
