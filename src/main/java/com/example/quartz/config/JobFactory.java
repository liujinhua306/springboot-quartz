package com.example.quartz.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @author Haoxy
 * Created in 2019-09-02.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
//@Component
public class JobFactory extends AdaptableJobFactory {

    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        // 调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        // 进行注入
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
