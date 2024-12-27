package com.sunshine.winter.beans.factory.beans.support;

import com.sunshine.winter.beans.factory.beans.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
    
}
