package com.phc.bilibiliinfo.home;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.util.Log;
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
    private static final String TAG = "homeGetViewAdapter";

    bilibiliHome data;

    public homeGetViewAdapter(bilibiliHome data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_get_video_item
                , parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        //View click
        view.setOnClickListener(new View.OnClickListener() {
            private TextView dialogHomeViewItemAv;
            private TextView dialogHomeViewItemBv;
            private TextView dialogHomeViewItemName;
            private ImageView dialogHomeViewItemImage;
            @Override
            public void onClick(View v) {
                //show dialog
                Log.d(TAG, "onClick: 点击了view");
                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.dialog_home_view_item, null);
                dialogHomeViewItemImage = (ImageView) dialogView.findViewById(R.id.dialog_home_view_item_image);
                dialogHomeViewItemName = (TextView) dialogView.findViewById(R.id.dialog_home_view_item_name);
                dialogHomeViewItemBv = (TextView) dialogView.findViewById(R.id.dialog_home_view_item_bv);
                dialogHomeViewItemAv = (TextView) dialogView.findViewById(R.id.dialog_home_view_item_av);
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext()).setView(dialogView)
                        .setTitle("up主与视频信息");
                bilibiliHome.DataBean.ArchivesBean archivesBean = data.getData().getArchives()
                        .get(viewHolder.getAdapterPosition());
                Picasso.get().load(archivesBean.getOwner().getFace()).into(dialogHomeViewItemImage);
                dialogHomeViewItemName.setText(archivesBean.getOwner().getName());
                dialogHomeViewItemAv.setText(String.valueOf("av"+archivesBean.getAid()));
                dialogHomeViewItemBv.setText(String.valueOf(archivesBean.getBvid()));
                builder.create().show();
            }
        });
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
        holder.activityHomeGetVideoItemTime.setText(R.string.time + new Date(archivesBean.getPubdate()).toString());
        holder.activityHomeGetVideoItemComment.setText("评论：" + String.valueOf(archivesBean.getStat().getReply()));
        holder.activityHomeGetVideoItemView.setText("播放量：" + String.valueOf(archivesBean.getStat().getView()));
        holder.activityHomeGetVideoItemLike.setText("点赞：" + String.valueOf(archivesBean.getStat().getLike()));
        holder.activityHomeGetVideoItemCoin.setText("硬币：" + String.valueOf(archivesBean.getStat().getCoin()));
        holder.activityHomeGetVideoItemShare.setText("分享：" + String.valueOf(archivesBean.getStat().getShare()));
        holder.activityHomeGetVideoItemDanmaku.setText("弹幕：" + String.valueOf(archivesBean.getStat().getDanmaku()));
        holder.activityHomeGetVideoItemTag.setText("动态：" + String.valueOf(archivesBean.getDynamic()));
        holder.activityHomeGetVideoItemIntroduce.setText("评论：" + String.valueOf(archivesBean.getDesc()));

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
