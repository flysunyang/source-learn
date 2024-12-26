package com.sunshine.winter.beans.factory.config;

import com.sunshine.winter.beans.PropertyValues;

public class BeanDefinition {
    
    private final Class<?> beanClass;
    
    private final PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }
    
}
