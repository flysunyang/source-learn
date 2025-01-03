package com.sunshine.winter.beans.factory.support;

import com.sunshine.winter.beans.factory.BeansException;
import com.sunshine.winter.beans.factory.DisposableBean;
import com.sunshine.winter.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonMap = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeanMap = new HashMap<>();

    @Override
    public Object getSingletonBean(String beanName) {
        return singletonMap.get(beanName);
    }

    @Override
    public void addSingleton(String beanName, Object singleton) {
        singletonMap.put(beanName, singleton);
    }

    @Override
    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeanMap.put(beanName, bean);
    }

    @Override
    public void destroySingletons() {
        Iterator<String> iterator = this.disposableBeanMap.keySet().iterator();
        while (iterator.hasNext()) {
            String beanName = iterator.next();
            DisposableBean disposableBean = disposableBeanMap.get(beanName);
            try {
                if (disposableBean != null) {
                    disposableBean.destroy();
                }
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
            iterator.remove();
        }
    }
}
