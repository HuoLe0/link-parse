package com.huole.learn.controller;

import com.huole.learn.entity.ParsingInfoDO;
import com.huole.learn.entity.ParsingInfoParam;
import com.huole.learn.entity.ResultModel;
import com.huole.learn.mapper.ParsingInfoMapper;
import com.huole.learn.service.VideoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
@RestController
@RequestMapping("/api/video")
public class VideoController {
    @Resource
    ParsingInfoMapper parsingInfoMapper;
    @Resource
    VideoService videoService;

    /***
     * 视频无水印链接解析
     * @param url 分享地址
     * @param openId 用户openId
     * @return
     */
    @PostMapping(value = "getVideoInfo")
    public ResultModel getVideoInfo(@RequestParam(value = "url") String url, @RequestParam(value = "openId") String openId) {
        return ResultModel.success(videoService.getVideoInfo(openId, url));
    }

    /***
     * 获取解析记录
     * @param openId
     * @return
     */
    @PostMapping(value = "getParsingInfo")
    public ResultModel<List> getVideoInfo(@RequestParam(value = "openId") String openId) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - 30);
        ParsingInfoParam param = new ParsingInfoParam();
        param.createCriteria().andUserOpenIdEqualTo(openId).andCreateTimeGreaterThan(calendar.getTime());
        List<ParsingInfoDO> parsingInfoList = parsingInfoMapper.selectByExample(param);
        return ResultModel.success(parsingInfoList);
    }
}
