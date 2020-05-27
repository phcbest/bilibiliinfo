package com.phc.bilibiliinfo.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.phc.bilibiliinfo.R;
import com.phc.bilibiliinfo.gsonBean.bilibiliVideo;
import com.phc.bilibiliinfo.gsonBean.bilibilionline;
import com.phc.bilibiliinfo.interfaceAll.upUi;
import com.phc.bilibiliinfo.utils.ToBvAv;
import com.phc.bilibiliinfo.utils.httpUtil;

public class home extends Fragment {
    private static final String TAG = "home";

    private EditText fragmentHomeVideo;
    private Button fragmentHomeVideoButton;
    private EditText fragmentHomeUP;
    private Button fragmentHomeUPButton;
    private Button fragmentHomeHomeButton;
    private Button fragmentHomeMainStationButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        //button click
        fragmentHomeHomeButtonClick();
        //on line number of people
        fragmentHomeMainStationButtonClick();
        //video query button
        fragmentHomeVideoButtonClick();

        return view;
    }

    private void fragmentHomeVideoButtonClick() {
        //editText if have import
            fragmentHomeVideoButton.setOnClickListener(new View.OnClickListener() {

                private String av;

                @Override
                public void onClick(View v) {
                    if (!"".equals(fragmentHomeVideo.getText().toString())){
                        //getAV
                        try {
                            av = new ToBvAv().bv2av(fragmentHomeVideo.getText().toString());

                            httpUtil util = new httpUtil(true, getContext(), new upUi() {
                                @Override
                                public void NewView(String callBackJson) {
                                    bilibiliVideo bv = new Gson().fromJson(callBackJson, bilibiliVideo.class);
                                    if (bv.getData() != null){
                                        Intent intent = new Intent(getActivity(),homeVideo.class);
                                        intent.putExtra("json",callBackJson);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(getContext(), "返回数据没有数据体，请检查一下BV号", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            util.execute("https://api.bilibili.com/x/web-interface/view?aid="+av+"&type=json");
                        }catch (Exception e){
                            Toast.makeText(getContext(), "BV号输入错误，注意在前面输入BV，检查一遍再次输入"
                                    , Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }else {
                        Toast.makeText(getContext(), "您没有输入BV号，请输入", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }

    private void fragmentHomeMainStationButtonClick() {
        //get website online number of people
        //https://api.bilibili.com/x/web-interface/online?&amp;jsonp=jsonp
        fragmentHomeMainStationButton.setOnClickListener(new View.OnClickListener() {
            private ArrayAdapter adapter;
            private String[] item;
            private ListView dialogHomeOnline;
            private AlertDialog.Builder builder;

            Handler handler = new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(@NonNull Message msg) {
                    if (msg.what == 100) {
                        httpUtil util = new httpUtil(false,getContext(), new upUi() {
                            @Override
                            public void NewView(String callBackJson) {
                                bilibilionline bill = new Gson().fromJson(callBackJson, bilibilionline.class);
                                item[0] = "番剧区：" +String.valueOf(bill.getData().getRegion_count().get_$13());
                                item[1] = "国创区：" +String.valueOf(bill.getData().getRegion_count().get_$167());
                                item[2] = "鬼畜区：" +String.valueOf(bill.getData().getRegion_count().get_$119());
                                item[3] = "资讯区：" +String.valueOf(bill.getData().getRegion_count().get_$202());
                                item[4] = "动画区：" +String.valueOf(bill.getData().getRegion_count().get_$1());
                                item[5] = "音乐区：" +String.valueOf(bill.getData().getRegion_count().get_$3());
                                item[6] = "舞蹈区：" +String.valueOf(bill.getData().getRegion_count().get_$129());
                                item[7] = "生活区：" +String.valueOf(bill.getData().getRegion_count().get_$181());
                                item[8] = "娱乐区：" +String.valueOf(bill.getData().getRegion_count().get_$5());
                                item[9] = "数码区：" + String.valueOf(bill.getData().getRegion_count().get_$188());
                                item[10] = "时尚区：" + String.valueOf(bill.getData().getRegion_count().get_$155());
                                item[11] = "游戏区：" + String.valueOf(bill.getData().getRegion_count().get_$4());
                                adapter.notifyDataSetChanged();
                            }
                        });
                        util.execute("https://api.bilibili.com/x/web-interface/online?&amp;jsonp=jsonp");
                        handler.sendEmptyMessageDelayed(100, 3000);
                    }
                    return false;
                }
            });

            @Override
            public void onClick(final View v) {
                httpUtil util = new httpUtil(true,getContext(), new upUi() {
                    @Override
                    public void NewView(final String callBackJson) {
                        bilibilionline bl = new Gson().fromJson(callBackJson, bilibilionline.class);
                        //builder dialog
                        builder = new AlertDialog.Builder(v.getContext());
                        item = new String[]{
                                "番剧区：" + bl.getData().getRegion_count().get_$13(),
                                "国创区：" + bl.getData().getRegion_count().get_$167(),
                                "鬼畜区：" + bl.getData().getRegion_count().get_$119(),
                                "资讯区：" + bl.getData().getRegion_count().get_$202(),
                                "动画区：" + bl.getData().getRegion_count().get_$1(),
                                "音乐区：" + bl.getData().getRegion_count().get_$3(),
                                "舞蹈区：" + bl.getData().getRegion_count().get_$129(),
                                "生活区：" + bl.getData().getRegion_count().get_$181(),
                                "娱乐区：" + bl.getData().getRegion_count().get_$5(),
                                "数码区：" + bl.getData().getRegion_count().get_$188(),
                                "时尚区：" + bl.getData().getRegion_count().get_$155(),
                                "游戏区：" + bl.getData().getRegion_count().get_$4()};
                        View view = LayoutInflater.from(v.getContext())
                                .inflate(R.layout.dialog_home_online, null);
                        dialogHomeOnline = (ListView) view.findViewById(R.id.dialog_home_online);
                        dialogHomeOnline.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(getContext(), item[position], Toast.LENGTH_SHORT).show();
                            }
                        });
                        adapter = new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_list_item_1,android.R.id.text1, item);
                        dialogHomeOnline.setAdapter(adapter);
                        builder.setView(view);
                        builder.setTitle("B站主站在线人数");

                        //handler message
                        handler.sendEmptyMessageDelayed(100, 3000);
                        //dialog not Show listen
                        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                handler.removeMessages(100);
                            }
                        });

                        builder.create().show();
                    }
                });
                util.execute("https://api.bilibili.com/x/web-interface/online?&amp;jsonp=jsonp");
            }
        });
    }

    private void fragmentHomeHomeButtonClick() {
        fragmentHomeHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //      click button get bilibili url  information
                new httpUtil(true,getContext(), new upUi() {
                    @Override
                    public void NewView(String callBackJson) {
                        Intent intent = new Intent(getActivity(), homeGetVideo.class);
                        intent.putExtra("Json", callBackJson);
                        startActivity(intent);
                    }
                }).execute("https://api.bilibili.com/x/web-interface/dynamic/region?&amp;jsonp=jsonp&amp;ps=30&amp;rid=1");
            }
        });

    }


    /**
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
