package com.xuqj.gamepicturebackend;

import com.xuqj.gamepicturebackend.app.LibraryApp;
import com.xuqj.gamepicturebackend.model.app.LibraryReport;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class LibraryAppTest {

    @Resource
    private LibraryApp libraryApp;

    @Test
    void testChat() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是xqj。我显示器的分辨率是2560*1440。";
        String answer = libraryApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        // 第二轮
        message = "我想找一些游戏壁纸，我该怎么找适合我显示器的壁纸呢？";
        answer = libraryApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        // 第三轮
        message = "能给我一些有上述壁纸的网站么？";
        answer = libraryApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithReport() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是xqj，我想找一些壁纸网站，有哪些推荐么";
        LibraryReport libraryReport = libraryApp.doChatWithReport(message, chatId);
        Assertions.assertNotNull(libraryReport);
    }

    @Test
    void doChatWithRag() {
        String chatId = UUID.randomUUID().toString();
        String message = "为什么上传的图片变模糊了？";
        String answer =  libraryApp.doChatWithRag(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithTools() {
        // 测试联网搜索问题的答案
        testMessage("请为我推荐一些制作壁纸，下载壁纸的网站？");

        String url = String.format("https://cn.bing.com/images/async?q=%s&mmasync=1", "高清壁纸");

        // 测试网页抓取：恋爱案例分析
        testMessage("请在" + url + "中为我挑一些图片？");

        // 测试资源下载：图片下载
        testMessage("直接下载一张高清壁纸图片为文件");

        // 测试终端操作：执行代码
        testMessage("执行 Python3 脚本来生成数据分析报告");

        // 测试文件操作：保存用户档案
        testMessage("保存'我的项目快完结了'这句话到文本中");
    }

    private void testMessage(String message) {
        String chatId = UUID.randomUUID().toString();
        String answer = libraryApp.doChatWithTools(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithMcp() {
        String chatId = UUID.randomUUID().toString();
        // 测试地图 MCP
        String message = "图片中是东方明珠塔，请给我5公里内合适的拍照打卡地点";
        String answer =  libraryApp.doChatWithMcp(message, chatId);
    }

    @Test
    void doChatWithMcp_server() {
        String chatId = UUID.randomUUID().toString();
        // 测试图片搜索 MCP
        String message = "帮我搜索一些群山的图片";
        String answer =  libraryApp.doChatWithMcp(message, chatId);
        Assertions.assertNotNull(answer);
    }

}

