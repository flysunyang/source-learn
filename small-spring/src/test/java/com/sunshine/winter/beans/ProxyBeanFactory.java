package com.sunshine.winter.beans;

import com.sunshine.winter.IUserDao;
import com.sunshine.winter.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyBeanFactory implements FactoryBean<IUserDao> {

    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            Map<String, String> userMap = new HashMap<>();
            userMap.put("1001", "Alice");
            userMap.put("1002", "Bob");
            userMap.put("1003", "Charles");
            return "你被代理了 " + method.getName() + "：" + userMap.get(args[0].toString());
        };
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
