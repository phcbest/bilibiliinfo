package com.phc.bilibiliinfo.music;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phc.bilibiliinfo.R;
import com.phc.bilibiliinfo.gsonBean.chetBean;
import com.phc.bilibiliinfo.interfaceAll.upUi;
import com.phc.bilibiliinfo.utils.httpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class music extends Fragment {
    private static final String TAG = "musicthis";

    private RecyclerView fragmentMusicRecyclerView;
    private EditText fragmentMusicEdit;
    private Button fragmentMusicSend;
    private ArrayList<chetBean> data = new ArrayList<>();
    private chatAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        initView(view);


        data.add(new chetBean(0, "天气：天气深圳\n"+"中英翻译：翻译i see you\n" +
                "歌词⑴：歌词稻香\n" +"歌词⑵：歌词稻香-周杰伦\n" + "笑话：笑话\n" + "计算⑴：计算1+1*2/3-4\n" +
                "计算⑵：1+1*2/3-4\n" + "域名⑴：域名qingyunke.com\n" + "域名⑵：qingyunke.com\n" +
                "ＩＰ⑴：归属127.0.0.1\n" + "ＩＰ⑵：127.0.0.1\n" + "手机⑴：归属13430108888\n" +
                "手机⑵：13430108888\n" + "智能聊天：你好"));
        data.add(new chetBean(1,"helloWorld"));
        Log.d(TAG, "onCreateView: "+data.get(0).getChetText());
        adapter = new chatAdapter(data);
        fragmentMusicRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentMusicRecyclerView.setAdapter(adapter);

        fragmentMusicSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(fragmentMusicEdit.getText().toString())) {
//                    show back data
                    httpUtil hu = new httpUtil(false, getContext(), new upUi() {

                        String content;
                        //创建适配器对象
                        @Override
                        public void NewView(String callBackJson) {
                            Log.d(TAG, "返回数据"+callBackJson);

                            try {
                                JSONObject jsonObject = new JSONObject(callBackJson);
                                content = jsonObject.getString("content");
                                data.add(new chetBean(0,content));
                                adapter.notifyItemInserted(data.size()-1);
                                fragmentMusicRecyclerView.scrollToPosition(data.size()-1);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(getContext(), "数据解析错误", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    hu.execute("https://api.qingyunke.com/api.php?key=free&appid=0&msg="+fragmentMusicEdit.getText().toString());
                    data.add(new chetBean(1,fragmentMusicEdit.getText().toString()));
                    adapter.notifyItemInserted(data.size()-1);
                    fragmentMusicRecyclerView.scrollToPosition(data.size()-1);
                    fragmentMusicEdit.setText("");
                } else {
                    data.add(new chetBean(0,"总得和我说点啥子吧"));
                    adapter.notifyItemInserted(data.size()-1);
                    fragmentMusicRecyclerView.scrollToPosition(data.size()-1);
                }
            }
        });

        return view;
    }


    private void initView(View view) {
        fragmentMusicRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_music_recyclerView);
        fragmentMusicEdit = (EditText) view.findViewById(R.id.fragment_music_edit);
        fragmentMusicSend = (Button) view.findViewById(R.id.fragment_music_send);
    }
}
