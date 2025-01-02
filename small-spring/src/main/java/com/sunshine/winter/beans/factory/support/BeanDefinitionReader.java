package com.sunshine.winter.beans.factory.support;

import com.sunshine.winter.beans.factory.BeansException;
import com.sunshine.winter.core.io.Resource;
import com.sunshine.winter.core.io.ResourceLoader;

public interface BeanDefinitionReader {
    
    BeanDefinitionRegistry getRegistry();
    
    ResourceLoader getResourceLoader();
    
    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
