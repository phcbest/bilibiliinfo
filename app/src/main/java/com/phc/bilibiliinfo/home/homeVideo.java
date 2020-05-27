package com.phc.bilibiliinfo.home;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.phc.bilibiliinfo.R;
import com.phc.bilibiliinfo.gsonBean.bilibiliVideo;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class homeVideo extends AppCompatActivity {
    private static final String TAG = "homeVideo";
    private LinearLayout activityHomeVideoLinearLayout;
    private ImageView activityHomeVideoImageView;
    private TextView activityHomeVideoText;
    private ImageView activityHomeVideoSmall;
    private TextView activityHomeVideoTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_video);
        initView();
        //get Json
        String json = getIntent().getStringExtra("json");
        bilibiliVideo bv = new Gson().fromJson(json, bilibiliVideo.class);
        bilibiliVideo.DataBean data = bv.getData();
        //show pic
        Picasso.get().load(data.getPic()).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(activityHomeVideoImageView);
        //show small pic
        Picasso.get().load("https://i0.hdslb.com/bfs/videoshot/" + data.getCid() + ".jpg")
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(activityHomeVideoSmall);

        //show up face
        if (data.getStaff() != null) {
            for (int i = 0; i < data.getStaff().size(); i++) {
                final bilibiliVideo.DataBean.StaffBean staffBean = data.getStaff().get(i);
                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
                layoutParams.leftMargin = 10;
                layoutParams.rightMargin = 10;
                imageView.setLayoutParams(layoutParams);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                        builder.setTitle(staffBean.getName());
                        builder.setMessage("工作：" + staffBean.getTitle());
                        builder.create().show();
                    }
                });
                Picasso.get().load(staffBean.getFace()).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(imageView);
                activityHomeVideoLinearLayout.addView(imageView);
            }
        } else {
            final bilibiliVideo.DataBean.OwnerBean owner = data.getOwner();
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
            layoutParams.leftMargin = 10;
            layoutParams.rightMargin = 10;
            imageView.setLayoutParams(layoutParams);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(homeVideo.this, owner.getName(), Toast.LENGTH_SHORT).show();
                }
            });
            Picasso.get().load(owner.getFace()).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(imageView);
            activityHomeVideoLinearLayout.addView(imageView);
        }
        //show text
        activityHomeVideoTitle.setText(data.getTitle());
        String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(Long.valueOf(data.getPubdate()) * 1000));
        activityHomeVideoText.setText(
                "时间：" + format +
                "\n简介: " + data.getDesc()+
                "\nAV号: av" + data.getAid()+
                "\nBV号: " + data.getBvid()+
                "\nCID: " + data.getCid()+
                "\n播放: " + data.getStat().getView()+
                "\n弹幕: " + data.getStat().getDanmaku()+
                "\n评论: " + data.getStat().getReply()+
                "\n点赞: " + data.getStat().getLike()+
                "\n硬币: " + data.getStat().getCoin()+
                "\n分享: " + data.getStat().getShare()+
                "\n收藏: " + data.getStat().getFavorite()

        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void initView() {
        activityHomeVideoLinearLayout = (LinearLayout) findViewById(R.id.activity_home_video_LinearLayout);
        activityHomeVideoImageView = (ImageView) findViewById(R.id.activity_home_video_ImageView);
        activityHomeVideoText = (TextView) findViewById(R.id.activity_home_video_Text);
        activityHomeVideoSmall = (ImageView) findViewById(R.id.activity_home_video_small);
        activityHomeVideoTitle = (TextView) findViewById(R.id.activity_home_video_Title);
    }
}
