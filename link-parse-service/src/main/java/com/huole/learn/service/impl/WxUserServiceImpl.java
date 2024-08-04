package com.huole.learn.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huole.learn.config.WxConfig;
import com.huole.learn.entity.WxUser;
import com.huole.learn.entity.WxUserDO;
import com.huole.learn.entity.WxUserParam;
import com.huole.learn.mapper.WxUserMapper;
import com.huole.learn.service.WxUserService;
import com.huole.learn.utils.DateUtil;
import com.huole.learn.utils.RestTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
@Service("wxUserService")
@Slf4j
public class WxUserServiceImpl implements WxUserService {

    @Resource
    private WxUserMapper wxUserMapper;

    @Resource
    private RestTemplateUtil restTemplateUtil;

    @Override
    public WxUser getUserInfoByOpenId(String openId) {
        WxUserParam param = new WxUserParam();
        param.createCriteria().andOpenIdEqualTo(openId);
        List<WxUserDO> userList = wxUserMapper.selectByExample(param);
        if (!userList.isEmpty()) {
            WxUser user = new WxUser();
            BeanUtils.copyProperties(userList.get(0), user);
            return user;
        }
        return null;
    }

    @Override
    public int insert(WxUser wxUser) {
        WxUserDO userDO = new WxUserDO();
        BeanUtils.copyProperties(wxUser, userDO);
        return wxUserMapper.insert(userDO);
    }

    @Override
    public int updateById(WxUser wxUser) {
        WxUserDO userDO = new WxUserDO();
        BeanUtils.copyProperties(wxUser, userDO);
        return wxUserMapper.updateByPrimaryKey(userDO);
    }

    @Override
    public WxUser singIn(String openId) {
        WxUser wxUser = getUserInfoByOpenId(openId);
        if (wxUser == null) {
            log.error("用户不存在");
        }
        Date signTime = wxUser.getEndSignInTime();//最后签到时间
        Date nowDate = new Date();
        Date startDate = DateUtil.getStartTime(nowDate);//今日开始时间
        Date endDate = DateUtil.getEndTime(nowDate);//今日结束时间
        if (signTime == null || signTime.before(startDate) || signTime.after(endDate)) {
            wxUser.setSignInSum(wxUser.getSignInSum() + 1);
            wxUser.setVideoNumber(wxUser.getVideoNumber() + 20);
            wxUser.setEndSignInTime(nowDate);
            WxUserDO userDO = new WxUserDO();
            BeanUtils.copyProperties(wxUser, userDO);
            wxUserMapper.updateByPrimaryKey(userDO);
        } else {
            log.error("重复签到");
        }
        return wxUser;
    }

    @Override
    public String getOpenId(String code) {
        String openId = null;
        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=").append(WxConfig.appId);
        url.append("&secret=").append(WxConfig.secret);
        url.append("&js_code=").append(code);
        url.append("&grant_type=authorization_code");
        String data = restTemplateUtil.getForObject(url.toString(), null, String.class);
        if (data == null) {
            log.error("openid解析异常:{}", data);
        }
        JSONObject jsonObject = JSON.parseObject(data);
        if (jsonObject.get("openid") == null) {
            log.error("openid解析异常:{}", jsonObject.getString("errmsg"));
        } else {
            openId = jsonObject.get("openid").toString();
        }
        return openId;
    }
}
