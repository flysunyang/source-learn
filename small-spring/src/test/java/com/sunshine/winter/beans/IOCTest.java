package com.sunshine.winter.beans;

import com.sunshine.winter.beans.factory.PropertyValue;
import com.sunshine.winter.beans.factory.PropertyValues;
import com.sunshine.winter.beans.factory.config.BeanDefinition;
import com.sunshine.winter.beans.factory.config.BeanReference;
import com.sunshine.winter.beans.factory.support.DefaultListableBeanFactory;
import com.sunshine.winter.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

public class IOCTest {
    
    @Test
    void testPrototype() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring3.xml");
        context.registerShutdownHook();

        MyUserService userService01 = context.getBean("userService", MyUserService.class);
        MyUserService userService02 = context.getBean("userService", MyUserService.class);

        System.out.println(userService01);
        System.out.println(userService02);

        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }

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
