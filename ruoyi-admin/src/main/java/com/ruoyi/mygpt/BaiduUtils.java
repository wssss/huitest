package com.ruoyi.mygpt;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class BaiduUtils {


//    @Value("${baidu.id}")
//    private String appid;
//
//    @Value("${baidu.secret}")
//    private String secret;
    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();


    public String getKey(String client_id, String secret) throws IOException {
        okhttp3.MediaType mediaType = okhttp3.MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "data");
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token?client_id=" + client_id +"&client_secret="+ secret + "&grant_type=client_credentials")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        String key = response.body().string();
        System.out.println(key);
        return key;
    }
}
