package com.example.GoIceland.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.GoIceland.R;
import com.example.GoIceland.adapters.ConcertAdapter;
import com.example.GoIceland.grids.StaggeredGridView;
import com.example.GoIceland.models.Concert;
import com.example.GoIceland.services.ConcertService;
import com.example.GoIceland.services.ConcertServiceStub;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public class ConcertFragment extends Fragment {

    private final static String ARG_POSITION = "position";
    private int m_CurrentPosition = -1;
    private StaggeredGridView m_Stgv;
    private ConcertAdapter m_Adapter;
    private ConcertService m_ConcertService;
    private ArrayList<Concert> m_ConcertList;

    public ConcertFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.grid_staggered_grid_view, container, false);

        m_Stgv = (StaggeredGridView) view.findViewById(R.id.stgv);
        int margin = getResources().getDimensionPixelSize(R.dimen.stgv_margin);

        m_Stgv.setItemMargin(margin);
        m_Stgv.setPadding(margin, 0, margin, 0);

        m_ConcertService = new ConcertServiceStub(this.getActivity());
        m_ConcertList = m_ConcertService.getConcertList();

        m_Adapter = new ConcertAdapter(this.getActivity(), m_ConcertList);
        m_Stgv.setAdapter(m_Adapter);
        m_Adapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, m_CurrentPosition);
    }
}
