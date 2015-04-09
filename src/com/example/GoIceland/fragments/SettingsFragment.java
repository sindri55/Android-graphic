package com.example.GoIceland.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.example.GoIceland.R;
import com.example.GoIceland.services.DateService;
import com.example.GoIceland.services.DateServiceStub;
import com.example.GoIceland.services.LocationService;
import com.example.GoIceland.services.LocationServiceStub;

import java.util.ArrayList;

/**
 * Created by Hannes on 9.4.2015.
 */
public class SettingsFragment extends Fragment {

    private LocationService m_LocationService;
    private DateService m_DateService;

    public SettingsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        m_LocationService = new LocationServiceStub();
        m_DateService = new DateServiceStub();

        ArrayList<String> locations = m_LocationService.getLocationList();
        Spinner locationSpinner = (Spinner) view.findViewById(R.id.location_spinner);
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, locations);
        locationAdapter.setDropDownViewResource(R.layout.settings_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);

        ArrayList<String> monthList = m_DateService.getMonthList();
        Spinner monthSpinner = (Spinner) view.findViewById(R.id.date_picker_month_spinner);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, monthList);
        monthAdapter.setDropDownViewResource(R.layout.settings_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        ArrayList<String> dayList = m_DateService.getDayList();
        Spinner daySpinner = (Spinner) view.findViewById(R.id.date_picker_day_spinner);
        ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, dayList);
        dayAdapter.setDropDownViewResource(R.layout.settings_dropdown_item);
        daySpinner.setAdapter(dayAdapter);

        return view;
    }
}
