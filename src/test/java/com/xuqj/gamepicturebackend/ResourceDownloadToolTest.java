package com.xuqj.gamepicturebackend;

import com.xuqj.gamepicturebackend.tools.ResourceDownloadTool;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ResourceDownloadToolTest {

    @Test
    public void testDownloadResource() {
        ResourceDownloadTool tool = new ResourceDownloadTool();
        String url = "https://p3-pc-sign.douyinpic.com/obj/tos-cn-i-0813c001/osgnAwgDAi9DAIBEACemAKAngeCkAAwAbyJAVS?from=876277922&lk3s=343af0a2&x-expires=2054059200&x-signature=QmLBt9pIhWIhyg4OxP7XrZPZyKw%3D";
        String fileName = "wallpaper1.png";
        String result = tool.downloadResource(url, fileName);
        assertNotNull(result);
    }
}

