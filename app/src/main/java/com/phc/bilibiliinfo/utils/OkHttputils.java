package com.phc.bilibiliinfo.utils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttputils {
    private static OkHttpClient client = new OkHttpClient().newBuilder()
            .build();

    public interface callBack {
        void success(String response);

        void fail(IOException e);
    }

    public static void doGetNetWork(String url, final callBack cb) {
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                cb.fail(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                cb.success(response.body().string());
            }
        });
    }
}
