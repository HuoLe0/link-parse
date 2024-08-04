package com.huole.learn.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
@Data
public class ParsingInfo {
    private Long id;
    private String userOpenId;
    private String downloadUrl;
    private String title;
    private Date createTime;
    //视频作者
    private String author;
    //视频封面地址
    private String cover;
}
