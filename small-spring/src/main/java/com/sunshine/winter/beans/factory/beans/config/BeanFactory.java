package com.sunshine.winter.beans.factory.beans.config;

import com.sunshine.winter.beans.factory.beans.BeansException;

public interface BeanFactory {
    
    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;
    
}
