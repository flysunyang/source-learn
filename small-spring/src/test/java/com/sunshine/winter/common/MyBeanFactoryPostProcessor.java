package com.sunshine.winter.common;

import com.sunshine.winter.beans.factory.BeansException;
import com.sunshine.winter.beans.factory.ConfigurableListableBeanFactory;
import com.sunshine.winter.beans.factory.PropertyValue;
import com.sunshine.winter.beans.factory.config.BeanDefinition;
import com.sunshine.winter.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("company", "-> ByteDance"));
    }
}
