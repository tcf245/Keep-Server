package com.keep.web;

import com.alibaba.fastjson.JSON;
import com.keep.domain.MessageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tcf24 on 2016/5/7.
 */
@RestController
public class NoTokenController {

    @RequestMapping("/noToken")
    @ResponseBody
    public String noToken(){

        MessageBean mb = new MessageBean();
        mb.setFlag(false);
        mb.setMsg("认证失败请登录！");
        return JSON.toJSONString(mb);

    }
}
