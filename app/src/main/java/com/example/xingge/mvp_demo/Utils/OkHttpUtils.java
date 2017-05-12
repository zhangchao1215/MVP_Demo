package com.example.xingge.mvp_demo.Utils;

import com.example.xingge.mvp_demo.App;
import com.example.xingge.mvp_demo.model.callback.NetWorkCallBack;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by xingge on 2017/4/19.
 */

public class OkHttpUtils {




    //保证OkHttpClient对象是单例的
    private OkHttpClient okHttpClient;

    private static OkHttpUtils okHttpUtils = null;
    private OkHttpUtils(){
        okHttpClient = new OkHttpClient.Builder().build();
    }

    public synchronized static OkHttpUtils getInstance(){
        if(okHttpUtils == null) {
            okHttpUtils = new OkHttpUtils();
        }
        return okHttpUtils;
    }

    public void get(String url, Map<String, String> params, final NetWorkCallBack callBack) {


        if (params != null && params.size() > 0) {
            StringBuffer sb = new StringBuffer(url);
            sb.append("?");
            Set<String> keys = params.keySet();

            for (String key : keys) {
                sb.append(key).append("=").append(params.get(key)).append("&");
            }

            url = sb.toString().substring(0, sb.length() - 1);
        }

        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (e != null && e.getMessage() != null)
                            callBack.onError(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                final String result = response.body().string();

                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });

            }
        });
    }


    }
