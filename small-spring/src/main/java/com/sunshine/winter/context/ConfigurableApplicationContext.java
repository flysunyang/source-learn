package com.sunshine.winter.context;

import com.sunshine.winter.beans.factory.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {
    
    void refresh() throws BeansException;
    
}
