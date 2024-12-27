package com.sunshine.winter.beans.factory.beans.support;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    
    private final Map<String, Object> singletonMap = new HashMap<>();
    
    @Override
    public Object getSingletonBean(String beanName) {
        return singletonMap.get(beanName);
    }

    @Override
    public void addSingleton(String beanName, Object singleton) {
        singletonMap.put(beanName, singleton);
    }
}
