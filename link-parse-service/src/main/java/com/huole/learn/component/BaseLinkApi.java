package com.huole.learn.component;


import com.huole.learn.entity.dto.VideoInfoDto;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
public interface BaseLinkApi {

    /**
     * 根据flag确定是否可以解析
     *
     * @param flag flag
     */
    boolean canParse(String flag);

    /**
     * 获取类型，如douyin、kuaishou等
     */
    String getLinkApiType();

    /**
     * 解析链接，返回解析对象
     *
     * @param flag flag
     */
    VideoInfoDto parse(String flag);
}
