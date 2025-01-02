package com.sunshine.winter.beans.factory;

import com.sunshine.winter.beans.factory.config.BeanFactory;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory {
    
    String[] getBeanDefinitionNames();
    
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
    
}
