package com.huole.learn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
@Component
public class WxConfig {
    public static String appId;
    public static String secret;

    @Value("${wx.appId}")
    private void setAppId(String appId) {
        WxConfig.appId = appId;
    }

    @Value("${wx.secret}")
    private void setSecret(String secret) {
        WxConfig.secret = secret;
    }
}
