package com.sunshine.winter.beans;

import com.sunshine.winter.beans.factory.support.DefaultListableBeanFactory;
import com.sunshine.winter.beans.factory.xml.XmlBeanDefinitionReader;
import org.junit.jupiter.api.Test;

public class XMLTest {
    
    @Test
    void testXML() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }
}
