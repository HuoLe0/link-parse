package com.huole.learn.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
@Data
public class WxUser {
    private Long id;
    private String name;
    private Integer videoNumber;
    private String openId;
    //累计签到次数
    private Integer signInSum;
    //最后签到时间
    private Date endSignInTime;
    //最后解析时间
    private Date lastParsingTime;
    private Date createTime;
}
