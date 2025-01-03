package com.sunshine.winter.beans;

import com.sunshine.winter.beans.factory.ApplicationContextAware;
import com.sunshine.winter.beans.factory.BeanClassLoaderAware;
import com.sunshine.winter.beans.factory.BeanFactoryAware;
import com.sunshine.winter.beans.factory.BeanNameAware;
import com.sunshine.winter.beans.factory.BeansException;
import com.sunshine.winter.beans.factory.DisposableBean;
import com.sunshine.winter.beans.factory.InitializingBean;
import com.sunshine.winter.beans.factory.config.BeanFactory;
import com.sunshine.winter.context.ApplicationContext;

public class UserService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private UserDao userDao;

    private String uId;

    private String location;

    private String company;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + ", 公司：" + company + ", 地点：" + location;
    }

    public void queryName(String id) {
        String name = userDao.queryUserName(id);
        System.out.printf("id:%s -> name:%s\n", id, name);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("execute userService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("execute userService.afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext:" + applicationContext);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("classLoader:" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory:" + beanFactory);
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("beanName:" + beanName);
    }
}
