package com.phc.bilibiliinfo.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.phc.bilibiliinfo.R;

public class home extends Fragment {
    private EditText fragmentHomeVideo;
    private Button fragmentHomeVideoButton;
    private EditText fragmentHomeUP;
    private Button fragmentHomeUPButton;
    private Button fragmentHomeHomeButton;
    private Button fragmentHomeMainStationButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        //i need get bilibili uri  information

        return view;
    }

    private void initView(View view) {
        fragmentHomeVideo = (EditText) view.findViewById(R.id.fragment_home_video);
        fragmentHomeVideoButton = (Button) view.findViewById(R.id.fragment_home_videoButton);
        fragmentHomeUP = (EditText) view.findViewById(R.id.fragment_home_UP);
        fragmentHomeUPButton = (Button) view.findViewById(R.id.fragment_home_UPButton);
        fragmentHomeHomeButton = (Button) view.findViewById(R.id.fragment_home_HomeButton);
        fragmentHomeMainStationButton = (Button) view.findViewById(R.id.fragment_home_main_station_Button);
    }
}
