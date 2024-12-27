package com.sunshine.winter.beans.factory.beans.config;

import com.sunshine.winter.beans.factory.beans.PropertyValues;

public class BeanDefinition {
    
    private Class<?> beanClass;
    
    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
