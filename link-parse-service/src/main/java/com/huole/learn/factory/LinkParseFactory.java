package com.huole.learn.factory;

import com.huole.learn.component.BaseLinkApi;
import com.huole.learn.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解析接口工厂类
 *
 * @author hanning.hn
 * @date 2024/8/3
 */
@Component
public class LinkParseFactory implements SmartInitializingSingleton {
    private final Logger log = LoggerFactory.getLogger(LinkParseFactory.class);

    final private List<BaseLinkApi> mediaApis;

    public LinkParseFactory() {
        mediaApis = new ArrayList<>();
    }

    public void add(BaseLinkApi baseLinkApi) {
        mediaApis.add(baseLinkApi);
    }

    public BaseLinkApi getMediaApi(String flag) {
        BaseLinkApi baseMediaApiFound = null;
        for (BaseLinkApi baseMediaApi : mediaApis) {
            if (baseMediaApi.canParse(flag)) {
                baseMediaApiFound = baseMediaApi;
            }
        }
        if (baseMediaApiFound == null) {
            log.error("未找到解析器: {}", flag);
        }
        return baseMediaApiFound;
    }

    @Override
    public void afterSingletonsInstantiated() {
        log.info("loading LinkParseFactory...");
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ((ConfigurableApplicationContext) SpringContextUtil.getApplicationContext()).getBeanFactory();
        String[] beanNames = beanFactory.getBeanNamesForType(BaseLinkApi.class);
        Arrays.stream(beanNames).forEach(beanName -> {
            this.add(((BaseLinkApi) SpringContextUtil.getBean(beanName)));
            log.info(String.format("loading [%s]", beanName));
        });
        log.info("loaded LinkParseFactory.");
    }
}
