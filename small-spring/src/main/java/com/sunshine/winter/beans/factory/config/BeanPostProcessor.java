package com.sunshine.winter.beans.factory.config;

import com.sunshine.winter.beans.factory.BeansException;

public interface BeanPostProcessor {
    
    Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException;
    
    Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException;
    
}
