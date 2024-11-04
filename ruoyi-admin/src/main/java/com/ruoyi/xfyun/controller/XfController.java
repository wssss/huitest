package com.ruoyi.xfyun.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.xfyun.XfTool;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/tiktok")
public class XfController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(XfController.class);

    @ApiOperation(value = "获取星火回答", notes = "获取星火回答")
    @PostMapping(value = "/xf")
    public AjaxResult getAnswer(@RequestBody Map params) {

        String text = params.get("messages").toString();
        if (StringUtils.isNotBlank(text)) {
            String result = "";
            try {
                result = XfTool.getAnswer(text);
            } catch (Exception e) {
                log.error("【文字转语音接口调用异常】", e);
            }
            return  AjaxResult.success(result);
        }else {
            return AjaxResult.error("text不能为空");
        }
    }


}
