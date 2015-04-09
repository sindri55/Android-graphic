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

        Bitmap image = BitmapFactory.decodeResource(m_Context.getResources(), R.drawable.concert);

        list.add(new Concert("Gunni Jóhannsson", "Kaplakrika", "Gunni stígur villtan dans í Kaplakrikanum og verður mikið gaman mikið fjör", "May 21, 2015", "15:00", image));
        list.add(new Concert("Gústafur Finnson", "Egilshöll", "Gústi kallinn stendur alltaf fyrir sínu...", "May 21, 2015", "15:00", image));
        list.add(new Concert("Brynjar Jónsson", "Heima", "Hann Brynjar spilar á harmonikku heima hjá sér undir teppi", "May 21, 2015", "15:00", image));

        return list;
    }
}
