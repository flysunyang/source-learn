package com.sunshine.winter.beans.factory.config;


import com.sunshine.winter.beans.factory.BeansException;

public interface BeanFactory {
    
    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;
    
}
