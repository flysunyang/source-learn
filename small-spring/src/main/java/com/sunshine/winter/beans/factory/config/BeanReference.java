package com.sunshine.winter.beans.factory.config;

public class BeanReference {

    private final String beanName;

    public String getBeanName() {
        return beanName;
    }

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
}
