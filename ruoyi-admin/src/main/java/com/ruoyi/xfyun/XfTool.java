package com.ruoyi.xfyun;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import okhttp3.*;

import com.google.gson.Gson;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


@Component
public class XfTool  extends WebSocketListener {

    protected static final Logger log = LoggerFactory.getLogger(XfTool.class);


    public static String hostUrl = "https://spark-api.xf-yun.com/v1.1/chat";
    public static String APPID = "1dc98697";//从开放平台控制台中获取
    public static String APIKEY = "ec589dcd65e841567bcdbd107fd15bf8";//从开放平台控制台中获取
    public static String APISecret = "ZjBjN2FjMjMzZWY0OGQ0MDU0YjA3ZThm";//从开放平台控制台中获取
    public static final Gson json = new Gson();
    public static String answer = "";
    private static volatile boolean lock = true;

    public static String getAnswer(String question) throws Exception {
        lock = true;
        answer = "";
        String authUrl = getAuthorizationUrl(hostUrl,APIKEY,APISecret);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        String url = authUrl.replace("https://","wss://").replace("http://","ws://");
        Request request = new Request.Builder().url(url).build();
        WebSocket webSocket = okHttpClient.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                new Thread(()->{
                    JsonObject frame = new JsonObject();
                    JsonObject header = new JsonObject();
                    JsonObject chat = new JsonObject();
                    JsonObject parameter = new JsonObject();
                    JsonObject payload = new JsonObject();
                    JsonObject message = new JsonObject();
                    JsonObject text = new JsonObject();
                    JsonArray ja = new JsonArray();

                    //填充header
                    header.addProperty("app_id",APPID);
                    header.addProperty("uid","123456789");
                    //填充parameter
                    chat.addProperty("domain","general");
                    chat.addProperty("random_threshold",0);
                    chat.addProperty("max_tokens",1024);
                    chat.addProperty("auditing","default");
                    parameter.add("chat",chat);
                    //填充payload
                    text.addProperty("role","user");
                    text.addProperty("content",question);
                    ja.add(text);
//            message.addProperty("text",ja.getAsString());
                    message.add("text",ja);
                    payload.add("message",message);
                    frame.add("header",header);
                    frame.add("parameter",parameter);
                    frame.add("payload",payload);
                    System.out.println("frame:\n" + frame.toString());
                    webSocket.send(frame.toString());
                }

                ).start();
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                super.onMessage(webSocket, text);
                System.out.println("text:\n" + text);
                ResponseData responseData = json.fromJson(text,ResponseData.class);
//        System.out.println("code:\n" + responseData.getHeader().get("code"));
                if(0 == responseData.getHeader().get("code").getAsInt()){
                    System.out.println("###########");
                    if(2 != responseData.getHeader().get("status").getAsInt()){
                        System.out.println("****************");
                        Payload pl = json.fromJson(responseData.getPayload(),Payload.class);
                        JsonArray temp = (JsonArray) pl.getChoices().get("text");
                        JsonObject jo = (JsonObject) temp.get(0);
                        answer += jo.get("content").getAsString();
//                System.out.println(answer);
                    }else {
                        Payload pl1 = json.fromJson(responseData.getPayload(),Payload.class);
                        JsonObject jsonObject = (JsonObject) pl1.getUsage().get("text");
                        int prompt_tokens = jsonObject.get("prompt_tokens").getAsInt();
                        JsonArray temp1 = (JsonArray) pl1.getChoices().get("text");
                        JsonObject jo = (JsonObject) temp1.get(0);
                        answer += jo.get("content").getAsString();
                        System.out.println("返回结果为：\n" + answer);
                        lock = false;
                        webSocket.close(3,"客户端主动断开链接");

                    }

                }else{
                    System.out.println("返回结果错误：\n" + responseData.getHeader().get("code") +  responseData.getHeader().get("message") );
                }

            }

            @Override
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                super.onMessage(webSocket, bytes);
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                super.onClosing(webSocket, code, reason);
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                super.onClosed(webSocket, code, reason);
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                super.onFailure(webSocket, t, response);
            }
        });
        while (lock) {
        }
        return answer;
    }




    //鉴权url
    public static String  getAuthorizationUrl(String hostUrl , String apikey ,String apisecret) throws Exception {
        //获取host
        URL url = new URL(hostUrl);
        //获取鉴权时间 date
        SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        System.out.println("format:\n" + format );
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date = format.format(new Date());
        //获取signature_origin字段
        StringBuilder builder = new StringBuilder("host: ").append(url.getHost()).append("\n").
                append("date: ").append(date).append("\n").
                append("GET ").append(url.getPath()).append(" HTTP/1.1");
        System.out.println("signature_origin:\n" + builder);
        //获得signatue
        Charset charset = Charset.forName("UTF-8");
        Mac mac = Mac.getInstance("hmacsha256");
        SecretKeySpec sp = new SecretKeySpec(apisecret.getBytes(charset),"hmacsha256");
        mac.init(sp);
        byte[] basebefore = mac.doFinal(builder.toString().getBytes(charset));
        String signature = Base64.getEncoder().encodeToString(basebefore);
        //获得 authorization_origin
        String authorization_origin = String.format("api_key=\"%s\",algorithm=\"%s\",headers=\"%s\",signature=\"%s\"",apikey,"hmac-sha256","host date request-line",signature);
        //获得authorization
        String authorization = Base64.getEncoder().encodeToString(authorization_origin.getBytes(charset));
        //获取httpurl
        HttpUrl httpUrl = HttpUrl.parse("https://" + url.getHost() + url.getPath()).newBuilder().//
                addQueryParameter("authorization", authorization).//
                addQueryParameter("date", date).//
                addQueryParameter("host", url.getHost()).//
                build();

        return httpUrl.toString();
    }





    //重写onFailure

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        super.onFailure(webSocket, t, response);
        System.out.println(response);
    }



    class ResponseData{
        private  JsonObject header;
        private  JsonObject payload;

        public JsonObject getHeader() {
            return header;
        }

        public JsonObject getPayload() {
            return payload;
        }
    }

    class Header{
        private int code ;
        private String message;
        private String sid;
        private String status;

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public String getSid() {
            return sid;
        }

        public String getStatus() {
            return status;
        }
    }

    class Payload{
        private JsonObject choices;
        private JsonObject usage;

        public JsonObject getChoices() {
            return choices;
        }

        public JsonObject getUsage() {
            return usage;
        }
    }

    class Choices{
        private int status;
        private int seq;
        private JsonArray text;

        public int getStatus() {
            return status;
        }

        public int getSeq() {
            return seq;
        }

        public JsonArray getText() {
            return text;
        }
    }

}
