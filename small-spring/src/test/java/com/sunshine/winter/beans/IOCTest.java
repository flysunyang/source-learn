package com.sunshine.winter.beans;

import com.sunshine.winter.beans.factory.config.BeanDefinition;
import com.sunshine.winter.beans.factory.config.BeanReference;
import com.sunshine.winter.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IOCTest {
    
    @Test
    void testPropertyInject() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryName("1001");
        userService.queryName("1002");
        userService.queryName("1003");
    }
    
    @Test
    void testUser() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        String beanName = "user";
        defaultListableBeanFactory.registerBeanDefinition(beanName, new BeanDefinition(User.class));
        User user = (User) defaultListableBeanFactory.getBean(beanName, "Alice");
        Assertions.assertEquals(user.getName(), "Alice");
    }

    @Test
    void testBeanFactory() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        String beanName = "userService";
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinition);

        UserService userService = (UserService) defaultListableBeanFactory.getBean(beanName);
        userService.queryUserInfo();
        UserService userService2 = (UserService) defaultListableBeanFactory.getBean(beanName);
        userService2.queryUserInfo();

        Assertions.assertSame(userService, userService2);
    }
}
