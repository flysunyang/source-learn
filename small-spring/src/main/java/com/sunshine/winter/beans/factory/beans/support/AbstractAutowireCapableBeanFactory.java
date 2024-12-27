package com.sunshine.winter.beans.factory.beans.support;

import com.sunshine.winter.beans.factory.beans.BeansException;
import com.sunshine.winter.beans.factory.beans.config.BeanDefinition;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();
    
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) {
        Object bean;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            applyPropertyValues(beanName, bean, args);
        } catch (BeansException ex) {
            throw new BeansException("Instantiation of bean failed", ex);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    protected void applyPropertyValues(String beanName, Object bean, Object args) {
        
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object... args) {
        Constructor<?> ctor = null;
        Constructor<?>[] declaredConstructors = beanDefinition.getBeanClass().getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (args != null && declaredConstructor.getParameterTypes().length == args.length) {
                ctor = declaredConstructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanName, beanDefinition, ctor, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}
