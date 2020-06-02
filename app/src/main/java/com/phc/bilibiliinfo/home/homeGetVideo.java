package com.phc.bilibiliinfo.home;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.phc.bilibiliinfo.R;
import com.phc.bilibiliinfo.gsonBean.bilibiliHome;
import com.phc.bilibiliinfo.interfaceAll.upUi;
import com.phc.bilibiliinfo.utils.httpUtil;

public class homeGetVideo extends AppCompatActivity {
    private static final String TAG = "homeGetVideo";
    private RecyclerView activityHomeGetVideoRecyclerView;
    private SwipeRefreshLayout activityHomeGetVideoSwiperefreshlayout;
    private bilibiliHome bhome;
    private homeGetViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_get_video);
        initView();
        //get intent callback data
        String json = getIntent().getStringExtra("Json");
        Log.d(TAG, "onCreate: " + json);
        //get json important data
        bhome = new Gson().fromJson(json, bilibiliHome.class);
        Log.d(TAG, "onCreate: "+ bhome);
        //adapter
        adapter = new homeGetViewAdapter(bhome);
        activityHomeGetVideoRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        activityHomeGetVideoRecyclerView.setAdapter(adapter);
        //pull down refactor
        activityHomeGetVideoSwiperefreshlayoutListenenr();
    }

    private void activityHomeGetVideoSwiperefreshlayoutListenenr() {
        activityHomeGetVideoSwiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                httpUtil util = new httpUtil(true,homeGetVideo.this, new upUi() {
                    @Override
                    public void NewView(String callBackJson) {
                        //get new bean
                        bilibiliHome bh = new Gson().fromJson(callBackJson, bilibiliHome.class);
                        //replace bean
                        bhome.setCode(bh.getCode());
                        bhome.setData(bh.getData());
                        bhome.setMessage(bh.getMessage());
                        bhome.setTtl(bh.getTtl());
                        Log.d(TAG, "onCreate: "+ bhome);
                        //user adapter notify
                        adapter.notifyDataSetChanged();
                    }
                });
                util.execute("https://api.bilibili.com/x/web-interface/dynamic/region?&amp;jsonp=jsonp&amp;ps=30&amp;rid=1");
                activityHomeGetVideoSwiperefreshlayout.setRefreshing(false);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void initView() {
        activityHomeGetVideoRecyclerView = (RecyclerView) findViewById(R.id.activity_home_get_video_recyclerView);
        activityHomeGetVideoSwiperefreshlayout = (SwipeRefreshLayout) findViewById(R.id.activity_home_get_video_swiperefreshlayout);
    }
}
