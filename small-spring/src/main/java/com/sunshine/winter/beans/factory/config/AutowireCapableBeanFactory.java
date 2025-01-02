package com.sunshine.winter.beans.factory.config;

import com.sunshine.winter.beans.factory.BeansException;

public interface AutowireCapableBeanFactory extends BeanFactory {
    
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;
    
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
    
}
