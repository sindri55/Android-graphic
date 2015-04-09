package com.example.GoIceland.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.GoIceland.R;

/**
 * Created by Sindri on 09/04/15.
 */
public class FlyToursFragment extends Fragment {

    public FlyToursFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_staggered_grid_view, container, false);


        return view;

    }

}
