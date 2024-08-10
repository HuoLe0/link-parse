package com.huole.learn.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
@Component
@SuppressWarnings({
        "rawtypes",
        "nochecked"
})
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String beanName) {
        ConfigurableApplicationContext configurableApplicationContext = ((ConfigurableApplicationContext) applicationContext);
        return configurableApplicationContext.getBean(beanName);
    }
}
