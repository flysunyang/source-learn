package com.sunshine.winter.beans.factory;

import com.sunshine.winter.beans.factory.config.BeanFactory;

public interface BeanFactoryAware extends Aware {
    
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
    
}
