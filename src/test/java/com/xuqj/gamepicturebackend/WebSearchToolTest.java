package com.xuqj.gamepicturebackend;

import com.xuqj.gamepicturebackend.tools.WebSearchTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WebSearchToolTest {

    @Value("${search-api.api-key}")
    private String searchApiKey;

    @Test
    public void testSearchWeb() {
        WebSearchTool tool = new WebSearchTool(searchApiKey);
        String query = "高清壁纸 baidu.com";
        String result = tool.searchWeb(query);
        assertNotNull(result);
    }
}

