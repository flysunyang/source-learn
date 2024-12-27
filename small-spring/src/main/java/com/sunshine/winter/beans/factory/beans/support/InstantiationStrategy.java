package com.sunshine.winter.beans.factory.beans.support;

import com.sunshine.winter.beans.factory.beans.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    
    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor<?> ctor, Object... args);
    
}
