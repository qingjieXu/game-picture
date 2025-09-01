package com.xuqj.gamepicturebackend.controller;

import com.xuqj.gamepicturebackend.agent.LibraryManus;
import com.xuqj.gamepicturebackend.app.LibraryApp;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private LibraryApp libraryApp;

    @Resource
    private ToolCallback[] allTools;

    @Resource
    private ChatModel dashscopeChatModel;

    /**
     * 同步接口
     * @param message
     * @param chatId
     * @return
     */
    @GetMapping("/library_app/chat/sync")
    public String doChatWithLibraryAppSync(String message, String chatId) {
        return libraryApp.doChat(message, chatId);
    }

    /**
     * SSE流式接口-返回Flux响应式对象
     * @param message
     * @param chatId
     * @return
     */
    @GetMapping(value = "/library_app/chat/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> doChatWithLibraryAppSSEType(String message, String chatId) {
        return libraryApp.doChatByStream(message, chatId);
    }

    /**
     * SSE流式接口-返回Flux对象
     * @param message
     * @param chatId
     * @return
     */
    @GetMapping(value = "/library_app/chat/sse")
    public Flux<ServerSentEvent<String>> doChatWithLibraryAppSSE(String message, String chatId) {
        return libraryApp.doChatByStream(message, chatId)
                .map(chunk -> ServerSentEvent.<String>builder()
                        .data(chunk)
                        .build());
    }

    /**
     * SSE流式接口-使用了SSEEmitter
     * @param message
     * @param chatId
     * @return
     */
    @GetMapping("/library_app/chat/sse/emitter")
    public SseEmitter doChatWithLoveAppSseEmitter(String message, String chatId) {
        // 创建一个超时时间较长的 SseEmitter
        SseEmitter emitter = new SseEmitter(180000L); // 3分钟超时
        // 获取 Flux 数据流并直接订阅
        libraryApp.doChatByStream(message, chatId)
                .subscribe(
                        // 处理每条消息
                        chunk -> {
                            try {
                                emitter.send(chunk);
                            } catch (IOException e) {
                                emitter.completeWithError(e);
                            }
                        },
                        // 处理错误
                        emitter::completeWithError,
                        // 处理完成
                        emitter::complete
                );
        // 返回emitter
        return emitter;
    }

    /**
     * 流式调用 Manus 超级智能体
     *
     * @param message
     * @return
     */
    @GetMapping("/manus/chat")
    public SseEmitter doChatWithManus(String message) {
        LibraryManus libraryManus = new LibraryManus(allTools, dashscopeChatModel);
        return libraryManus.runStream(message);
    }

}

