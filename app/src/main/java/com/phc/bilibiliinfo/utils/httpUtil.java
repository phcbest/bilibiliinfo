package com.phc.bilibiliinfo.utils;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.phc.bilibiliinfo.interfaceAll.upUi;
import com.phc.bilibiliinfo.startInit.myApplication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * 版权：没有版权 看得上就用
 *
 * @author peng
 * 创建日期：2020/5/24 09
 * 描述： visit network , get json return
 */
public class httpUtil extends AsyncTask<String,String,String> {
    private static final String TAG = "httpUtil";
    
    private ProgressDialog progressDialog;

    private Context context;
    private upUi upUi;

    public httpUtil(Context context, upUi upUi) {
        this.context = context;
        this.upUi = upUi;
    }

    //use Service get
    @Override
    protected void onPreExecute() {
        //start dialog
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("梦想是现实的延续,现实是梦想的终点");
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        StringBuilder sb = new StringBuilder();
        HttpsURLConnection connection = null;
        //url
        try {
            URL url = new URL(strings[0]);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(8000);
            connection.setConnectTimeout(8000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line ;
//            circulate read
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connection != null){
            connection.disconnect();
        }
        publishProgress(sb.toString());
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        upUi.NewView(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //get data ok , not show progressDialog
        progressDialog.cancel();
    }
}
