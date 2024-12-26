package com.sunshine.winter.beans.factory.support;

import com.sunshine.winter.beans.BeansException;
import com.sunshine.winter.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException;
    
}
