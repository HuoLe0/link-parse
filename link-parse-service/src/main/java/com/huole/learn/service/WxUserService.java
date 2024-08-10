package com.huole.learn.service;

import com.huole.learn.entity.ResultModel;
import com.huole.learn.entity.WxUser;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
public interface WxUserService {

    /**
     * 获取微信用户信息
     *
     * @param openId
     * @return
     */
    WxUser getUserInfoByOpenId(String openId);

    /**
     * 插入微信用户信息
     *
     * @param wxUser
     * @return
     */
    int insert(WxUser wxUser);

    /**
     * 更新微信用户信息
     *
     * @param wxUser
     * @return
     */
    int updateById(WxUser wxUser);

    /**
     * 签到
     *
     * @param openId
     * @return 累计签到次数
     */
    ResultModel<WxUser> singIn(String openId);

    /***
     * 获取微信用户openId
     * @param code
     * @return
     */
    String getOpenId(String code);
}
