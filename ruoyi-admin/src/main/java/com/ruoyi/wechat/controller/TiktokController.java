package com.ruoyi.wechat.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.mygpt.ChatGPTUtils;
import com.ruoyi.wechat.CatBean;
import com.ruoyi.wechat.GetToken;
import com.ruoyi.wechat.WeixinToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tiktok")
public class TiktokController {

    @Autowired
    private GetToken getToken;

    @Autowired
    private CatBean catBean;

    @Autowired
    private ChatGPTUtils chatGPTUtils;
    @GetMapping("/token/fate")
    public AjaxResult token()
    {
        return AjaxResult.success(WeixinToken.token);
    }

    @GetMapping("/token/cat")
    public AjaxResult cat()
    {
        String cat = getToken.getToken(catBean.getAPPID(), catBean.getAPP_SECRECT()).getAccess_token();
        return AjaxResult.success(cat);
    }

    @PostMapping("/chat")
    public AjaxResult ask(@RequestBody HashMap<String, ArrayList<Map<String, String>>> m) {
        Map<String, String> response = new HashMap<>();

        ArrayList<Map<String, String>> input = m.get("messages");// 是一个包含多条 message 的list
        String output = chatGPTUtils.chat(input);

//        response.put("data", output);

        return AjaxResult.success(output);
    }

}
