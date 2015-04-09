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
        ArrayList<String> monthList = m_DateService.getMonthList();
        ArrayList<String> dayList = m_DateService.getDayList();

        Spinner locationSpinner = (Spinner) view.findViewById(R.id.location_spinner);
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, locations);
        locationAdapter.setDropDownViewResource(R.layout.settings_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);

        Spinner monthFromSpinner = (Spinner) view.findViewById(R.id.date_picker_from_month_spinner);
        ArrayAdapter<String> monthFromAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, monthList);
        monthFromAdapter.setDropDownViewResource(R.layout.settings_dropdown_item);
        monthFromSpinner.setAdapter(monthFromAdapter);
        monthFromSpinner.setSelection(monthFromAdapter.getPosition("April"));

        Spinner dayFromSpinner = (Spinner) view.findViewById(R.id.date_picker_from_day_spinner);
        ArrayAdapter<String> dayFromAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, dayList);
        dayFromAdapter.setDropDownViewResource(R.layout.settings_dropdown_item);
        dayFromSpinner.setAdapter(dayFromAdapter);
        dayFromSpinner.setSelection(dayFromAdapter.getPosition("10"));


        Spinner monthToSpinner = (Spinner) view.findViewById(R.id.date_picker_to_month_spinner);
        ArrayAdapter<String> monthToAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, monthList);
        monthToAdapter.setDropDownViewResource(R.layout.settings_dropdown_item);
        monthToSpinner.setAdapter(monthToAdapter);
        monthToSpinner.setSelection(monthToAdapter.getPosition("April"));

        Spinner dayToSpinner = (Spinner) view.findViewById(R.id.date_picker_to_day_spinner);
        ArrayAdapter<String> dayToAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, dayList);
        dayToAdapter.setDropDownViewResource(R.layout.settings_dropdown_item);
        dayToSpinner.setAdapter(dayToAdapter);
        dayToSpinner.setSelection(dayToAdapter.getPosition("17"));

        return view;
    }
}
