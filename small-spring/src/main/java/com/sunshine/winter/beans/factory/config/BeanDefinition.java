package com.sunshine.winter.beans.factory.config;


import com.sunshine.winter.beans.factory.PropertyValues;

public class BeanDefinition {
    
    private Class<?> beanClass;
    
    private PropertyValues propertyValues;
    
    private String initMethod;
    
    private String destroyMethod;

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setInitMethod(String initMethod) {
        this.initMethod = initMethod;
    }

    public void setDestroyMethod(String destroyMethod) {
        this.destroyMethod = destroyMethod;
    }

    public String getInitMethod() {
        return initMethod;
    }

    public String getDestroyMethod() {
        return destroyMethod;
    }
}
