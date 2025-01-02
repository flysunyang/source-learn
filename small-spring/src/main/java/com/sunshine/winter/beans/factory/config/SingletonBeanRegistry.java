package com.sunshine.winter.beans.factory.config;

public interface SingletonBeanRegistry {
    
    Object getSingletonBean(String beanName);
    
    void addSingleton(String beanName, Object singleton);
    
}
