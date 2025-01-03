package com.sunshine.winter.beans.factory;

public interface InitializingBean {
    
    void afterPropertiesSet() throws Exception;
    
}
