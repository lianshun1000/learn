package com.learn.springai.repository;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author lianshun
 * 2025/9/6 下午7:00
 */
@Component
public class InMemoryChatHistoryRepository implements ChatHistoryRepository {
    private final Map<String, List<String>> chatHistory = new HashMap<>();

    @Override
    public void save(String type, String chatId) {
        List<String> chatIds = chatHistory.computeIfAbsent(type, k -> new ArrayList<>());
        if (chatIds.contains(chatId)) {
            return;
        }
        chatIds.add(chatId);
    }

    @Override
    public List<String> getChartIds(String type) {
        return chatHistory.getOrDefault(type, List.of());
    }
}
