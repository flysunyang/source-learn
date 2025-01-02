package com.sunshine.winter.beans.factory.config;

import com.sunshine.winter.beans.factory.BeansException;
import com.sunshine.winter.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成之后，实例化 bean 对象之前，提供修改 BeanDefinition 属性的机制
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
