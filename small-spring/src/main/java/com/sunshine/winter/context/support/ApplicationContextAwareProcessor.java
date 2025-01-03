package com.sunshine.winter.context.support;

import com.sunshine.winter.beans.factory.ApplicationContextAware;
import com.sunshine.winter.beans.factory.BeansException;
import com.sunshine.winter.beans.factory.config.BeanPostProcessor;
import com.sunshine.winter.context.ApplicationContext;

public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
