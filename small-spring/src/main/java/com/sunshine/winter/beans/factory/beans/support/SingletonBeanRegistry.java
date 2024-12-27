package com.sunshine.winter.beans.factory.beans.support;

public interface SingletonBeanRegistry {
    
    Object getSingletonBean(String beanName);
    
    void addSingleton(String beanName, Object singleton);
    
}
