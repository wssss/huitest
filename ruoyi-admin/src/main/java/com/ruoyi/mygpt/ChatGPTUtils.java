package com.ruoyi.mygpt;


import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;


@Component
public class ChatGPTUtils {
    @Value("${douyin.key}")
    private  String token;



    public String chat(ArrayList<Map<String, String>> records) {
        // record 包含 多条 message，每条 message 可能来自用户，可能来自 assistant

        String url = "https://chat.deadpoet.me/v1/chat/completions";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);
        headers.setConnection("keep-alive");
        headers.add("user-agent", "Application");


        // 设置聊天请求参数
        Map<String, Object> request = new HashMap<>();
        request.put("model", "gpt-3.5-turbo");
        request.put("max_tokens", 500);
        request.put("messages", records);
        request.put("stream", false);

        // 发送POST请求
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(15000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        HttpEntity<?> requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        String response = null;

        // 解析响应
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            response = responseEntity.getBody();
            //System.out.println(response);
        } else {
            System.out.println("Error: " + responseEntity.getBody());
        }
        if (response == null) {
            response = "无内容";
        }
        JSONObject jsonObject = JSONObject.parseObject(response);
        JSONArray jsonArray = jsonObject.getJSONArray("choices");
        JSONObject messageObject = jsonArray.getJSONObject(0).getJSONObject("message");
        String role = messageObject.getString("role");
        String content = messageObject.getString("content");

        return content;
    }





}
