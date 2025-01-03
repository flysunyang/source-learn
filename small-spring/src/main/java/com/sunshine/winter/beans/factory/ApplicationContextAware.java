package com.sunshine.winter.beans.factory;

import com.sunshine.winter.context.ApplicationContext;

public interface ApplicationContextAware extends Aware {
    
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
    
}
