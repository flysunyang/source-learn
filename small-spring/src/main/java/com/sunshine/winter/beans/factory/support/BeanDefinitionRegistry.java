package com.sunshine.winter.beans.factory.support;

import com.sunshine.winter.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
    
    boolean containsBeanDefinition(String beanName);
}
