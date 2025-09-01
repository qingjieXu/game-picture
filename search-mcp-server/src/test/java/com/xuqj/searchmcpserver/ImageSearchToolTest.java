package com.xuqj.searchmcpserver;

import com.xuqj.searchmcpserver.tools.ImageSearchTool;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImageSearchToolTest {

    @Resource
    private ImageSearchTool imageSearchTool;

    @Test
    void searchImage() {
        String result = imageSearchTool.searchImage("game");
        Assertions.assertNotNull(result);
    }
}

