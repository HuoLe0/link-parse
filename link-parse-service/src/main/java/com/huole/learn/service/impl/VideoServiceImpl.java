package com.huole.learn.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huole.learn.entity.ParsingInfoDO;
import com.huole.learn.entity.WxUser;
import com.huole.learn.entity.dto.VideoInfoDto;
import com.huole.learn.factory.LinkParseFactory;
import com.huole.learn.mapper.ParsingInfoMapper;
import com.huole.learn.service.VideoService;
import com.huole.learn.service.WxUserService;
import com.huole.learn.utils.HttpClientUtil;
import com.huole.learn.utils.RestTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
@Service
@Slf4j
public class VideoServiceImpl implements VideoService {

    private static final String PEARKTRUE_URL = "https://api.pearktrue.cn/api/video/douyin/?url=%s";

    @Resource
    private LinkParseFactory linkParseFactory;

    @Resource(name = "wxUserService")
    private WxUserService wxUserService;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private RestTemplateUtil restTemplateUtil;

    @Resource
    private ParsingInfoMapper parsingInfoMapper;

    @Override
    public VideoInfoDto getVideoInfo(String openid, String url) {
        WxUser wxUser = wxUserService.getUserInfoByOpenId(openid);
        if (wxUser == null) {
            log.error("未查到用户信息");
            return null;
        } else if (wxUser.getVideoNumber() < 1) {
            log.error("视频解析次数不足");
            return null;
        }
        isContainsStrings(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("User-Agent", "Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Mobile Safari/537.36");
        httpHeaders.set("Referer", url);
        VideoInfoDto videoInfoDto = linkParseFactory.getMediaApi(url).parse(url);

        wxUser.setVideoNumber(wxUser.getVideoNumber() - 1);
        wxUser.setLastParsingTime(new Date());
        wxUserService.updateById(wxUser);
        ParsingInfoDO parsingInfo = new ParsingInfoDO();
        parsingInfo.setTitle(videoInfoDto.getTitle());
        parsingInfo.setDownloadUrl(videoInfoDto.getUrl());
        parsingInfo.setAuthor(videoInfoDto.getAuthor());
        parsingInfo.setCover(videoInfoDto.getCover());
        parsingInfo.setUserOpenId(wxUser.getOpenId());
        parsingInfo.setCreateTime(new Date());
        parsingInfoMapper.insert(parsingInfo);
        return videoInfoDto;
    }

    @Override
    public VideoInfoDto parsingDyVideoInfo(String url, HttpHeaders httpHeaders) {
        JSONObject parsedRes = JSON.parseObject(HttpUtil.get(String.format(PEARKTRUE_URL, url)));
        JSONObject videoInfo = parsedRes.getJSONObject("data");

        VideoInfoDto videoInfoDto = new VideoInfoDto();
        videoInfoDto.setTime(videoInfo.getString("time"));
        videoInfoDto.setCover(videoInfo.getString("cover"));
        videoInfoDto.setUrl(videoInfo.getString("url"));
        videoInfoDto.setTitle(videoInfo.getString("title"));
        videoInfoDto.setAuthor(videoInfo.getString("author"));
        videoInfoDto.setAvatar(videoInfo.getString("music_cover"));
        return videoInfoDto;
    }

    @Override
    public VideoInfoDto parsingKsuVideoInfo(String url, HttpHeaders httpHeaders) {
        Matcher matcher = Pattern.compile("(https?://www.kuaishou.com/[\\S]*)").matcher(url);
        VideoInfoDto videoInfoDto = null;
        if (matcher.find()) {
            url = matcher.group(1);
            url = restTemplate.headForHeaders(url).getLocation().toString();

            Map<String, String> headers = new HashMap<>();
            headers.put("User-Agent", httpHeaders.get("User-Agent").get(0));
            headers.put("Referer", httpHeaders.get("Referer").get(0));
            String html = HttpClientUtil.get(url);
            Matcher matcherUrl = Pattern.compile("\"backupUrl\":\\[\"http.*?]").matcher(html);
            Matcher matcherJson = Pattern.compile("<script>window.__APOLLO_STATE__=(.*?);\\(function").matcher(html);
            if (matcherJson.find()) {
                String json = matcherJson.group(0).replace("<script>window.__APOLLO_STATE__=", "").replace(";(function", "");
                JSONObject res = JSON.parseObject(json);
                JSONObject defaultRes = res.getJSONObject("defaultClient");
                JSONObject visionVideoDetailPhoto = null;
                JSONObject visionVideoDetailAuthor = null;
                for (String key : defaultRes.keySet()) {
                    if (key.contains("VisionVideoDetailPhoto") && !key.contains("$")) {
                        visionVideoDetailPhoto = defaultRes.getJSONObject(key);
                    }
                    if (key.contains("VisionVideoDetailAuthor") && !key.contains("$")) {
                        visionVideoDetailAuthor = defaultRes.getJSONObject(key);
                    }
                }
                if (visionVideoDetailPhoto == null || visionVideoDetailAuthor == null) {
                    return null;
                }

                videoInfoDto = new VideoInfoDto();

                videoInfoDto.setUrl(visionVideoDetailPhoto.getString("photoH265Url"));
                videoInfoDto.setTitle(visionVideoDetailPhoto.getString("caption"));
                videoInfoDto.setAuthor(visionVideoDetailAuthor.getString("name"));
                videoInfoDto.setAvatar(visionVideoDetailAuthor.getString("headerUrl"));
                videoInfoDto.setCover(visionVideoDetailPhoto.getString("coverUrl"));
                videoInfoDto.setTime(visionVideoDetailPhoto.getString("timestamp"));
            }


        }
        if (videoInfoDto == null) {
            log.error("视频解析异常: {}", url);
            return null;
        }
        return videoInfoDto;
    }

    @Override
    public VideoInfoDto phpParsingVideoInfo(String url) {
        url = "https://video.xtyu.top/?url=" + url;
        String htmlContent = restTemplateUtil.getForObject(url, null, String.class);
        if (htmlContent == null) {
            log.error("视频解析异常: {}", url);
            return null;
        }
        VideoInfoDto videoInfoDto = JSONArray.parseObject(htmlContent).getObject("data", VideoInfoDto.class);
        if (videoInfoDto == null) {
            log.error("视频解析异常: {}", url);
            return null;
        }
        return videoInfoDto;
    }


    void isContainsStrings(String url) {
        String[] strings = new String[]{"pipix", "douyin", "huoshan", "h5.weishi", "isee.weishi", "weibo.com", "oasis.weibo", "zuiyou",
                "bbq.bilibili", "kuaishou", "quanmin", "moviebase", "hanyuhl", "eyepetizer", "immomo", "vuevideo",
                "xiaokaxiu", "ippzone", "qq.com", "ixigua.com"
        };
        for (String s : strings) {
            if (url.contains(s)) {
                return;
            }
        }
        log.error("链接格式错误: {}", url);
    }
}
