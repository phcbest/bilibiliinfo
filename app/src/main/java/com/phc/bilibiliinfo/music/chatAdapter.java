package com.phc.bilibiliinfo.music;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phc.bilibiliinfo.R;
import com.phc.bilibiliinfo.gsonBean.chetBean;

import java.util.List;

/**
 * 版权：没有版权 看得上就用
 *
 * @author peng
 * 创建日期：2020/6/1 21
 * 描述：
 */
public class chatAdapter extends RecyclerView.Adapter<chatAdapter.ViewHolder> {
    private static final String TAG = "chatAdapter";

    List<chetBean> data;

    public chatAdapter(List<chetBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_chat, parent, false);
        Log.d(TAG, "onCreateViewHolder: " + R.layout.recycler_chat);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        chetBean cb = data.get(position);
        Log.d(TAG, "onBindViewHolder: " + cb.getChet());
        //is seed
        if (cb.getChet() == 1) {
            Log.d(TAG, "onBindViewHolder: 发送消息");
            holder.recyclerChatseedLayout.setVisibility(View.VISIBLE);
            holder.recyclerChatLayout.setVisibility(View.GONE);
            holder.recyclerChatseedText.setText(cb.getChetText());
        }
        if (cb.getChet() == 0) {
            Log.d(TAG, "onBindViewHolder: 接受消息");
            holder.recyclerChatLayout.setVisibility(View.VISIBLE);
            holder.recyclerChatseedLayout.setVisibility(View.GONE);
            String chetText = cb.getChetText();
            String replace = chetText.replace("{br}", "\n");
            holder.recyclerChatText.setText(replace);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout recyclerChatLayout;
        TextView recyclerChatText;
        LinearLayout recyclerChatseedLayout;
        TextView recyclerChatseedText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerChatLayout = (LinearLayout) itemView.findViewById(R.id.recycler_chat_layout);
            recyclerChatText = (TextView) itemView.findViewById(R.id.recycler_chat_text);
            recyclerChatseedLayout = (LinearLayout) itemView.findViewById(R.id.recycler_chatseed_layout);
            recyclerChatseedText = (TextView) itemView.findViewById(R.id.recycler_chatseed_text);
        }
    }
}
