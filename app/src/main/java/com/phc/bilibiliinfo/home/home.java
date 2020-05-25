package com.phc.bilibiliinfo.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.phc.bilibiliinfo.R;
import com.phc.bilibiliinfo.interfaceAll.upUi;
import com.phc.bilibiliinfo.utils.httpUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class home extends Fragment {
    private static final String TAG = "home";

    private EditText fragmentHomeVideo;
    private Button fragmentHomeVideoButton;
    private EditText fragmentHomeUP;
    private Button fragmentHomeUPButton;
    private Button fragmentHomeHomeButton;
    private Button fragmentHomeMainStationButton;


    //https://api.bilibili.com/x/web-interface/online?&amp;jsonp=jsonp
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);

        //button click
        fragmentHomeHomeButtonClick();


        return view;
    }

    private void fragmentHomeHomeButtonClick() {
        fragmentHomeHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //      click button get bilibili url  information
                new httpUtil(getContext(), new upUi() {
                    @Override
                    public void NewView(String callBackJson) {
                        Intent intent = new Intent(getActivity(), homeGetVideo.class);
                        intent.putExtra("Json",callBackJson);
                        startActivity(intent);
                    }
                }).execute("https://api.bilibili.com/x/web-interface/dynamic/region?&amp;jsonp=jsonp&amp;ps=30&amp;rid=1");
            }
        });

    }


    /**
     *
     * @param view
     */
    private void initView(View view) {
        fragmentHomeVideo = (EditText) view.findViewById(R.id.fragment_home_video);
        fragmentHomeVideoButton = (Button) view.findViewById(R.id.fragment_home_videoButton);
        fragmentHomeUP = (EditText) view.findViewById(R.id.fragment_home_UP);
        fragmentHomeUPButton = (Button) view.findViewById(R.id.fragment_home_UPButton);
        fragmentHomeHomeButton = (Button) view.findViewById(R.id.fragment_home_HomeButton);
        fragmentHomeMainStationButton = (Button) view.findViewById(R.id.fragment_home_main_station_Button);
    }
}
