package com.sunshine.winter.beans;

import cn.hutool.core.io.IoUtil;
import com.sunshine.winter.core.io.DefaultResourceLoader;
import com.sunshine.winter.core.io.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ResourceTest {

    private DefaultResourceLoader resourceLoader;

    @BeforeEach
    void init() {
        resourceLoader = new DefaultResourceLoader();
    }
    
    @Test
    void testClassPath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:test.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        Assertions.assertEquals(content, "system.key=1231331231");
    }

    @Test
    void testFile() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/test.properties");
        String content = IoUtil.readUtf8(resource.getInputStream());
        Assertions.assertEquals(content, "system.key=1231331231");
    }

    @Test
    void testURL() throws IOException {
        Resource resource = resourceLoader.getResource("https://raw.githubusercontent.com/flysunyang/source-learn/refs/heads/main/small-spring/src/test/resources/test.properties");
        String content = IoUtil.readUtf8(resource.getInputStream());
        Assertions.assertEquals(content, "system.key=1231331231");
    }
}
