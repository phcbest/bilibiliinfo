package com.phc.bilibiliinfo.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phc.bilibiliinfo.R;
import com.phc.bilibiliinfo.gsonBean.bilibiliHome;
import com.squareup.picasso.Picasso;

import java.sql.Date;

/**
 * 版权：没有版权 看得上就用
 *
 * @author peng
 * 创建日期：2020/5/25 15
 * 描述：
 */
public class homeGetViewAdapter extends RecyclerView.Adapter<homeGetViewAdapter.ViewHolder> {
    bilibiliHome data;


    public homeGetViewAdapter(bilibiliHome data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_get_video_item
                , parent, false);
        //View click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show dialog
            }
        });
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        bilibiliHome.DataBean.ArchivesBean archivesBean = data.getData().getArchives().get(position);
        //show Pic
        Picasso.get().load(archivesBean.getPic()).into(holder.activityHomeGetVideoItemImage);
        holder.activityHomeGetVideoItemTitle.setText(String.valueOf(archivesBean.getTitle()));
        //set Date
        holder.activityHomeGetVideoItemTime.setText(R.string.time+ new Date(archivesBean.getPubdate()).toString());
        holder.activityHomeGetVideoItemComment.setText("评论："+String.valueOf(archivesBean.getStat().getReply()));
        holder.activityHomeGetVideoItemView.setText("播放量："+String.valueOf(archivesBean.getStat().getView()));
        holder.activityHomeGetVideoItemLike.setText("点赞："+String.valueOf(archivesBean.getStat().getLike()));
        holder.activityHomeGetVideoItemCoin.setText("硬币："+String.valueOf(archivesBean.getStat().getCoin()));
        holder.activityHomeGetVideoItemShare.setText("分享："+String.valueOf(archivesBean.getStat().getShare()));
        holder.activityHomeGetVideoItemDanmaku.setText("弹幕："+String.valueOf(archivesBean.getStat().getDanmaku()));
        holder.activityHomeGetVideoItemTag.setText("动态："+String.valueOf(archivesBean.getDynamic()));
        holder.activityHomeGetVideoItemIntroduce.setText("评论："+String.valueOf(archivesBean.getDesc()));
    }

    @Override
    public int getItemCount() {
        return data.getData().getArchives().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView activityHomeGetVideoItemImage;
        TextView activityHomeGetVideoItemTitle;
        TextView activityHomeGetVideoItemTime;
        TextView activityHomeGetVideoItemComment;
        TextView activityHomeGetVideoItemView;
        TextView activityHomeGetVideoItemLike;
        TextView activityHomeGetVideoItemCoin;
        TextView activityHomeGetVideoItemShare;
        TextView activityHomeGetVideoItemDanmaku;
        TextView activityHomeGetVideoItemTag;
        TextView activityHomeGetVideoItemIntroduce;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            activityHomeGetVideoItemImage = (ImageView) itemView.findViewById(R.id.activity_home_get_video_item_image);
            activityHomeGetVideoItemTitle = (TextView) itemView.findViewById(R.id.activity_home_get_video_item_title);
            activityHomeGetVideoItemTime = (TextView) itemView.findViewById(R.id.activity_home_get_video_item_time);
            activityHomeGetVideoItemComment = (TextView) itemView.findViewById(R.id.activity_home_get_video_item_comment);
            activityHomeGetVideoItemView = (TextView) itemView.findViewById(R.id.activity_home_get_video_item_view);
            activityHomeGetVideoItemLike = (TextView) itemView.findViewById(R.id.activity_home_get_video_item_like);
            activityHomeGetVideoItemCoin = (TextView) itemView.findViewById(R.id.activity_home_get_video_item_coin);
            activityHomeGetVideoItemShare = (TextView) itemView.findViewById(R.id.activity_home_get_video_item_share);
            activityHomeGetVideoItemDanmaku = (TextView) itemView.findViewById(R.id.activity_home_get_video_item_danmaku);
            activityHomeGetVideoItemTag = (TextView) itemView.findViewById(R.id.activity_home_get_video_item_Tag);
            activityHomeGetVideoItemIntroduce = (TextView) itemView.findViewById(R.id.activity_home_get_video_item_introduce);
        }
    }
}
