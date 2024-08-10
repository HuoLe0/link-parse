package com.huole.learn.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huole.learn.entity.dto.VideoInfoDto;
import com.huole.learn.utils.HttpClientUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 快手链接解析api
 *
 * @author ZuoBro
 * date: 2021/5/20
 * time: 21:41
 */
@Component
public class KuaiShouApi implements BaseLinkApi {
    public static final String MEDIA_API_TYPE = "kuaishou";

    private static final Pattern ACCESS_PATTERN = Pattern.compile("(https?://www.kuaishou.com/[\\S]*)|(https?://v.kuaishou.com/[\\S]*)");


    @Resource
    private RestTemplate restTemplate;

    @Override
    public boolean canParse(String flag) {
        return ACCESS_PATTERN.matcher(flag).find();
    }

    @Override
    public String getLinkApiType() {
        return MEDIA_API_TYPE;
    }

    @Override
    public VideoInfoDto parse(String flag) {
        VideoInfoDto videoInfoDto = new VideoInfoDto();
        Matcher matcher = ACCESS_PATTERN.matcher(flag);
        if (matcher.find()) {
            String url = matcher.group(0);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("User-Agent", "Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Mobile Safari/537.36");
            httpHeaders.set("Referer", url);
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
            if (url.contains("/fw/photo/")) {
//                return parseVideoOrPhotos(url, httpHeaders);
            } else if (url.contains("/fw/long-video/")) {
                // 长视频
//                return this.parseLongVideo(url, httpHeaders);
            }
        }
        return videoInfoDto;
    }

}
