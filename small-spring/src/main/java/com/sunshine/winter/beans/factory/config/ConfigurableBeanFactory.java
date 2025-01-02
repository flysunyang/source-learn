package com.sunshine.winter.beans.factory.config;

import com.sunshine.winter.beans.factory.HierachicalBeanFactory;

public interface ConfigurableBeanFactory extends HierachicalBeanFactory, SingletonBeanRegistry {
    
    String SCOPE_SINGLETON = "singleton";
    
    String SCOPE_PROTOTYPE = "prototype";
    
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
    
}
