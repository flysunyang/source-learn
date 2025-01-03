package com.sunshine.winter.beans.factory;

public interface FactoryBean<T> {
    
    T getObject() throws Exception;
    
    Class<?> getObjectType();
    
    boolean isSingleton();
    
}
