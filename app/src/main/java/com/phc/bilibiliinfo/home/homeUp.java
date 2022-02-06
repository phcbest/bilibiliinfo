package com.phc.bilibiliinfo.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.phc.bilibiliinfo.R;
import com.phc.bilibiliinfo.gsonBean.bilibiliAnimation;
import com.phc.bilibiliinfo.gsonBean.bilibiliWorks;
import com.phc.bilibiliinfo.gsonBean.bilibiliup;
import com.phc.bilibiliinfo.interfaceAll.upUi;
import com.phc.bilibiliinfo.utils.httpUtil;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.List;

public class homeUp extends AppCompatActivity {
    private static final String TAG = "homeUp";
    private ImageView activityHomeUpPic;
    private TextView activityHomeUpName;
    private TextView activityHomeUpMessage;
    private LinearLayout activityHomeUpWorks;
    private LinearLayout activityHomeUpAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_up);
        initView();

        String upJson = getIntent().getStringExtra("upJson");
        bilibiliup.DataBean data = new Gson().fromJson(upJson, bilibiliup.class).getData();
        //show pic
        Picasso.get().load(data.getFace())
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(activityHomeUpPic);
        //show name
        activityHomeUpName.setText(data.getName());
        //show all massage
        String officialName;
        if (!"".equals(data.getOfficial().getTitle())) {
            officialName = data.getOfficial().getTitle();
        } else {
            officialName = "没有官方认证";
        }
        activityHomeUpMessage.setText(
                "性别：" + data.getSex()
                        + "\n简介：" + data.getSign()
                        + "\n等级：" + data.getLevel()
                        + "\n生日：" + data.getBirthday()
                        + "\n认证：" + officialName
        );
        //show works
        httpUtil works = new httpUtil(false, this, new upUi() {
            @Override
            public void NewView(String callBackJson) {
                bilibiliWorks bilibiliWorks = new Gson().fromJson(callBackJson, bilibiliWorks.class);
                try {
                    final List<com.phc.bilibiliinfo.gsonBean.bilibiliWorks.DataBean.ListBean.VlistBean>
                            vlist = bilibiliWorks.getData().getList().getVlist();
                    for (int i = 0; i < vlist.size(); i++) {
                        final com.phc.bilibiliinfo.gsonBean.bilibiliWorks.DataBean.ListBean.VlistBean
                                vlistBean = vlist.get(i);
                        final String pic = vlistBean.getPic();
                        ImageView imageView = new ImageView(homeUp.this);
                        //加载up主作品图片
                        Log.d(TAG, "作品图片: " + pic);
                        Picasso.get().load(pic)
                                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                                .into(imageView);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                                750, 500);
                        layoutParams.rightMargin = 10;
                        layoutParams.leftMargin = 10;
                        imageView.setLayoutParams(layoutParams);
                        //show information
                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                                builder.setTitle(vlistBean.getTitle());
                                builder.setMessage(
                                        "时长：" + vlistBean.getLength()
                                                + "\n简介:" + vlistBean.getDescription()
                                                + "\n" + vlistBean.getBvid()
                                );
                                builder.create().show();
                            }
                        });
                        activityHomeUpWorks.addView(imageView);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(homeUp.this, "返回数据解析错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        works.execute("https://api.bilibili.com/x/space/arc/search?mid=" + data.getMid() + "&pn=1&ps=25&jsonp=jsonp");

        //show Animation
        httpUtil animation = new httpUtil(false, homeUp.this, new upUi() {
            @Override
            public void NewView(String callBackJson) {
                try {
                    JSONObject jsonObject = new JSONObject(callBackJson);
                    Boolean status = jsonObject.getBoolean("status");
                    if (status) {
                        bilibiliAnimation ba = new Gson().fromJson(callBackJson, bilibiliAnimation.class);
                        final List<bilibiliAnimation.DataBean.ResultBean> result = ba.getData().getResult();
                        for (int i = 0; i < result.size(); i++) {
                            final bilibiliAnimation.DataBean.ResultBean resultBean = result.get(i);
                            ImageView image = new ImageView(homeUp.this);
                            Picasso.get().load(resultBean.getCover())
                                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                                    .into(image);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(500, 750);
                            layoutParams.leftMargin = 10;
                            layoutParams.leftMargin = 10;
                            image.setLayoutParams(layoutParams);
                            image.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                                    builder.setTitle(resultBean.getTitle());
                                    builder.setMessage(
                                            "追番人数:" + resultBean.getFavorites()
                                                    + "\n介绍:" + resultBean.getBrief()
                                    );
                                    builder.create().show();
                                }
                            });
                            activityHomeUpAnimation.addView(image);
                        }
                    } else {
                        Toast.makeText(homeUp.this, "追番隐私未公开", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(homeUp.this, "数据解析出现问题", Toast.LENGTH_SHORT).show();
                }
            }
        });
        animation.execute("https://space.bilibili.com/ajax/Bangumi/getList?mid=" + data.getMid());


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void initView() {
        activityHomeUpPic = (ImageView) findViewById(R.id.activity_home_up_pic);
        activityHomeUpName = (TextView) findViewById(R.id.activity_home_up_name);
        activityHomeUpMessage = (TextView) findViewById(R.id.activity_home_up_message);
        activityHomeUpWorks = (LinearLayout) findViewById(R.id.activity_home_up_works);
        activityHomeUpAnimation = (LinearLayout) findViewById(R.id.activity_home_up_animation);
    }
}
