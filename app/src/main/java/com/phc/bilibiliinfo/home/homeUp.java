package com.phc.bilibiliinfo.home;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
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
import com.phc.bilibiliinfo.utils.OkHttputils;
import com.phc.bilibiliinfo.utils.bean.FollowBean;
import com.phc.bilibiliinfo.utils.httpUtil;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class homeUp extends AppCompatActivity {
    private static final String TAG = "homeUp";
    private ImageView activityHomeUpPic;
    private TextView activityHomeUpName;
    private TextView activityHomeUpMessage;
    private LinearLayout activityHomeUpWorks;
    private LinearLayout activityHomeUpAnimation;
    private TextView mActivityHomeFollow;
    private CountDownTimer countDownTimer;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.onFinish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_up);
        initView();

        String upJson = getIntent().getStringExtra("upJson");
        final bilibiliup.DataBean data = new Gson().fromJson(upJson, bilibiliup.class).getData();
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

        countDownTimer = new CountDownTimer(Long.MAX_VALUE, 1000) {

            int history1 = 0;

            @Override
            public void onTick(long millisUntilFinished) {
                OkHttputils.doGetNetWork("https://api.bilibili.com/x/relation/stat?vmid=" + data.getMid(),
                        new OkHttputils.callBack() {
                            @Override
                            public void success(final String response) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        FollowBean followBean = new Gson().fromJson(response, FollowBean.class);
                                        String color = "#808080";
                                        String followStatus = "";
                                        int abs = Math.abs(history1 - followBean.getData().getFollower());
                                        if (history1 > followBean.getData().getFollower()) {
                                            color = "#7cb342";
                                            followStatus = "↓" + abs;
                                        } else if (history1 < followBean.getData().getFollower()) {
                                            color = "#e53935";
                                            followStatus = "↑" + abs;
                                        }
                                        Spanned spanned = Html.fromHtml(
                                                "<font color='#ff6c00' size='4'> follow数</font>" +
                                                        "<font  color='" + color + "' >" + followBean.getData().getFollower() + "</font>&nbsp;" +
                                                        "<font color='" + color + "' >" + followStatus + "</font>");
                                        history1 = followBean.getData().getFollower();
                                        mActivityHomeFollow.setText(spanned);
                                    }
                                });
                            }

                            @Override
                            public void fail(IOException e) {

                            }
                        });

            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
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
        mActivityHomeFollow = (TextView) findViewById(R.id.activity_home_follow);
    }
}
