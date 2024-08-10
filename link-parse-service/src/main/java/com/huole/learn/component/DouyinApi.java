package com.huole.learn.component;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huole.learn.entity.dto.VideoInfoDto;
import org.springframework.stereotype.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
@Component
public class DouyinApi implements BaseLinkApi {
    private static final String MEDIA_API_TYPE = "douyin";
    private static final Pattern FLAG_PATTERN = Pattern.compile("(https?://v.douyin.com/[\\S]*)|(https?://www.iesdouyin.com/[\\S]*)");
    private static final String PEARKTRUE_URL = "https://api.pearktrue.cn/api/video/douyin/?url=%s";

    @Override
    public boolean canParse(String flag) {
        return FLAG_PATTERN.matcher(flag).find();
    }

    @Override
    public String getLinkApiType() {
        return MEDIA_API_TYPE;
    }

    @Override
    public VideoInfoDto parse(String flag) {
        Matcher matcher = FLAG_PATTERN.matcher(flag);
        if (matcher.find()) {
            // 解析单个视频
            return parseVideo(flag);
        }
        return null;
    }

    private VideoInfoDto parseVideo(String url) {
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
}
