package com.learn.springai.controller;

import com.learn.springai.entity.vo.MessageVo;
import com.learn.springai.repository.ChatHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lianshun
 * 2025/9/6 下午7:09
 */
@RestController
@RequestMapping("/ai/history")
@RequiredArgsConstructor
public class ChatHistoryController {
    private final ChatHistoryRepository chatHistoryRepository;
    private final ChatMemory chatMemory;

    @GetMapping("/{type}")
    public List<String> getChatIds(@PathVariable("type") String type) {
        return chatHistoryRepository.getChartIds(type);
    }

    @GetMapping("/{type}/{chatId}")
    public List<MessageVo> getChatHistory(@PathVariable("type") String type, @PathVariable("chatId") String chatId) {
        List<Message> messages = chatMemory.get(chatId);
        if (CollectionUtils.isEmpty(messages)) {
            return List.of();
        }
        return messages.stream().map(MessageVo::new).collect(Collectors.toList());
    }
}
