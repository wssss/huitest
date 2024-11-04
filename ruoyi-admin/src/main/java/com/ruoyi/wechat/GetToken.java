package com.ruoyi.wechat;



import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class GetToken {

    private Logger logger = LoggerFactory.getLogger(GetToken.class);

    public AccessToken getToken(String appid, String appSecrect) {

        AccessToken token = null;

        String url = "https://developer.toutiao.com/api/apps/v2/token";
        Map map = new HashMap<String, String>();
        map.put("appid", appid);
        map.put("secret", appSecrect);
        map.put("grant_type", "client_credential");
        JSONObject obj = new JSONObject(map);
        logger.info(map.toString());

        JSONObject result = CommonUtil.httpsRequest(url, "POST", obj.toJSONString());
        logger.info(result.toString());
        if (result != null) {

            try {
                JSONObject jsonObj = result.getJSONObject("data");
                token = new AccessToken();

                token.setAccess_token(jsonObj.getString("access_token"));

                token.setExpires_in(jsonObj.getLong("expires_in"));
                logger.info(token.toString());
            } catch (Exception e) {
                token = null;
                e.printStackTrace();
                logger.error("系统出错了！");
            }
        } else {
            token = null;
            // 获取token失败
            logger.error("jsonObject为空，获取token失败");
        }
        return token;

    }
}