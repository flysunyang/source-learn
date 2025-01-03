package com.sunshine.winter.beans.factory.config;

import com.sunshine.winter.beans.factory.DisposableBean;

public interface SingletonBeanRegistry {
    
    Object getSingletonBean(String beanName);
    
    void addSingleton(String beanName, Object singleton);
    
    void registerDisposableBean(String beanName, DisposableBean bean);
    
    void destroySingletons();
}
