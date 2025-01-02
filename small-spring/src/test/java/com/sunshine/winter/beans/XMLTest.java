package com.sunshine.winter.beans;

import com.sunshine.winter.beans.factory.support.DefaultListableBeanFactory;
import com.sunshine.winter.beans.factory.xml.XmlBeanDefinitionReader;
import com.sunshine.winter.common.MyBeanFactoryPostProcessor;
import com.sunshine.winter.common.MyBeanPostProcessor;
import com.sunshine.winter.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XMLTest {
    
    @Test
    void testXML() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());
    }
    
    @Test
    void testBeanFactoryPostProcessorAndBeanPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        Assertions.assertEquals(result, "Alice, 公司：-> ByteDance, 地点：-> BeiJin");
    }
    
    @Test
    void testXmlContext() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring2.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        Assertions.assertEquals(result, "Alice, 公司：-> ByteDance, 地点：-> BeiJin");
    }
}
