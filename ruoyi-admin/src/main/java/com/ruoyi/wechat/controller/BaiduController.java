package com.ruoyi.wechat.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.mygpt.BaiduUtils;
import com.ruoyi.wechat.WeixinToken;
import com.ruoyi.xfyun.controller.XfController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/tiktok")
public class BaiduController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(XfController.class);


    @Autowired
    BaiduUtils baiduUtils;



    @GetMapping("/baidu/key")
    public AjaxResult cat()
    {

        try {
            String key = WeixinToken.key;
            return AjaxResult.success(key);
        }
        catch (Exception e){
            log.error("获取失败", e);
            return AjaxResult.error("获取失败");
        }

    }

    @GetMapping("/baidu/audio_key")
    public AjaxResult audio()
    {

        try {
            String key = WeixinToken.audio_key;
            return AjaxResult.success(key);
        }
        catch (Exception e){
            log.error("获取失败", e);
            return AjaxResult.error("获取失败");
        }

    }
}
