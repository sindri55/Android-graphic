package com.example.GoIceland.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.GoIceland.R;
import com.example.GoIceland.adapters.CategoryAdapter;
import com.example.GoIceland.grids.StaggeredGridView;
import com.example.GoIceland.models.Category;
import com.example.GoIceland.services.CategoryService;
import com.example.GoIceland.services.CategoryServiceStub;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public class HomeFragment extends Fragment {

    private final static String ARG_POSITION = "position";
    private int m_CurrentPosition = -1;
    private StaggeredGridView m_Stgv;
    private CategoryAdapter m_Adapter;
    private CategoryService m_CategoryService;
    private ArrayList<Category> m_CategoryList;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.grid_staggered_grid_view, container, false);

        m_Stgv = (StaggeredGridView) view.findViewById(R.id.stgv);
        int margin = getResources().getDimensionPixelSize(R.dimen.stgv_margin);

        m_Stgv.setItemMargin(margin);
        m_Stgv.setPadding(margin, 0, margin, 0);

        m_CategoryService = new CategoryServiceStub(this.getActivity());
        m_CategoryList = m_CategoryService.getCategoryList();

        m_Adapter = new CategoryAdapter(this.getActivity(), m_CategoryList);
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
