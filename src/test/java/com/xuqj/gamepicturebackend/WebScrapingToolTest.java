package com.xuqj.gamepicturebackend;

import com.xuqj.gamepicturebackend.tools.WebScrapingTool;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WebScrapingToolTest {

    @Test
    public void testScrapeWebPage() {
        WebScrapingTool tool = new WebScrapingTool();
        String url = String.format("https://cn.bing.com/images/async?q=%s&mmasync=1", "高清壁纸");
        String result = tool.scrapeWebPage(url);
        assertNotNull(result);
    }
}

