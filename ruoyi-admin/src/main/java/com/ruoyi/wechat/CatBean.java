package com.ruoyi.wechat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource(value = "classpath:application.yml")
@ConfigurationProperties(prefix = "cat")
public class CatBean {

    @Value("${appid}")
    private String APPID;

    @Value("${secret}")
    private String APP_SECRECT;


    public String getAPPID() {
        return APPID;
    }

    public void setAPPID(String APPID) {
        this.APPID = APPID;
    }

    public String getAPP_SECRECT() {
        return APP_SECRECT;
    }

    public void setAPP_SECRECT(String APP_SECRECT) {
        this.APP_SECRECT = APP_SECRECT;
    }
}
