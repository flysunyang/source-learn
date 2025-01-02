package com.sunshine.winter.beans.factory.support;

import com.sunshine.winter.beans.factory.BeansException;
import com.sunshine.winter.beans.factory.config.BeanDefinition;
import com.sunshine.winter.beans.factory.config.BeanFactory;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    private Object doGetBean(String beanName, Object... args) {
        Object singleton = getSingletonBean(beanName);
        if (singleton != null) {
            return singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object... args);

    protected abstract BeanDefinition getBeanDefinition(String beanName);

}
