package com.huole.learn.service;

import com.huole.learn.entity.dto.VideoInfoDto;
import org.springframework.http.HttpHeaders;

import java.io.IOException;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
public interface VideoService {
    /**
     * 解析视频并保存解析信息
     * @param openid
     * @param url
     * @return
     */
    VideoInfoDto getVideoInfo(String openid, String url);

    /**
     * 抖音解析
     * @param url 分享链接
     * @return
     */
    VideoInfoDto parsingDyVideoInfo(String url, HttpHeaders httpHeaders);

    /**
     * 快手解析
     * @param url 分享链接
     * @return
     */
    VideoInfoDto parsingKsuVideoInfo(String url,HttpHeaders httpHeaders) throws IOException;

    /**
     * PHP服务解析（暂用）
     * @param url 分享链接
     * @return
     */
    VideoInfoDto phpParsingVideoInfo(String url);
}
