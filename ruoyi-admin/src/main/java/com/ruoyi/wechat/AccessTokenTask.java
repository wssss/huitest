package com.ruoyi.wechat;

import com.ruoyi.mygpt.BaiduUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenTask {

    private Logger logger = LoggerFactory.getLogger(AccessTokenTask.class);

    @Autowired
    private GetToken getToken;
    @Autowired
    private WeChatBean weChatBean;

    @Autowired
    private BaiduUtils baiduUtils;

    /**
     * access_token 是小程序的全局唯一调用凭据
     * access_token 的有效期为 2 个小时，需要定时刷新 access_token，重复获取会导致之前一次获取的
     * access_token 失效
     * 延迟一秒执行
     */
    @Scheduled(initialDelay = 1000, fixedDelay = 7000*1000 )
    public void getTouTiaoAccessToken(){    
        try {
            String token = getToken.getToken(weChatBean.getAPPID(), weChatBean.getAPP_SECRECT()).getAccess_token();
            //将获取到的token放到内存
            WeixinToken.token = token;
            logger.info("获取到的accessToken为"+token);
        } catch (Exception e) {
            logger.error("获取adcessToken出错，信息如下");
            e.printStackTrace();
        }

    }

    @Scheduled(initialDelay = 3000, fixedDelay = 6000 * 24 * 1000 )
    public void getBaiduAccessToken(){
        try {
            String key = baiduUtils.getKey("IiZR662YWZQ9WLeYXqfDlGYE", "rtT7P5GCGoPczlUSCvZ7rGx03d3YXU22");
            //将获取到的token放到内存
            WeixinToken.key = key;
            String audio_key = baiduUtils.getKey("bFAs359D8xeqF41XLIUqcF8w", "NuX1OnGC0uEj59DjqDGGDQ2ZP1PWORb2");
            logger.info("辉辉写作获取到的accessKey为"+key);
            WeixinToken.audio_key = audio_key;
            logger.info("audio的 audio Key 为" + audio_key);
        } catch (Exception e) {
            logger.error("获取adcessKey出错，信息如下");
            e.printStackTrace();
        }

    }
}
