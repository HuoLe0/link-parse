package com.huole.learn.controller;

import com.huole.learn.entity.ResultModel;
import com.huole.learn.entity.WxUser;
import com.huole.learn.service.WxUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
@RestController
@RequestMapping("/api/wx")
@Slf4j
public class WxUserController {

    @Resource
    private WxUserService wxUserService;

    @PostMapping(value = "auth")
    public ResultModel<String> wxAuth(@RequestParam(value = "js_code") String code) {
        String openId = wxUserService.getOpenId(code);
        return ResultModel.success("openId获取成功", openId);
    }

    /**
     * 登录、注册、获取用户信息
     * @param openId
     * @return
     */
    @PostMapping(value = "login")
    public ResultModel<WxUser> login(@RequestParam(value = "openId") String openId, String name) {
        WxUser wxUser = wxUserService.getUserInfoByOpenId(openId);
        if (wxUser == null) {
            wxUser = new WxUser();
            wxUser.setName(name);
            wxUser.setOpenId(openId);
            wxUser.setVideoNumber(999);
            wxUser.setSignInSum(1);
            wxUser.setCreateTime(new Date());
            wxUserService.insert(wxUser);
        }
        return ResultModel.success(wxUser);
    }

    /***
     * 签到
     * @param openId
     * @return
     */
    @PostMapping(value = "signIn")
    public ResultModel<WxUser> sign(@RequestParam(value = "openId") String openId) {
        return wxUserService.singIn(openId);
    }
}
