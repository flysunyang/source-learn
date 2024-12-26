package com.sunshine.winter.beans.factory.support;

public interface SingletonBeanRegistry {
    
    Object getSingleton(String beanName);
    
    void addSingleton(String beanName, Object singletonInstance);
    
}
