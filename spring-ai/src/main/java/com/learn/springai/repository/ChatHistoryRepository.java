package com.learn.springai.repository;

import java.util.List;

/**
 * @author lianshun
 * 2025/9/6 下午6:55
 */

public interface ChatHistoryRepository {
    /**
     * 保存会话记录
     * @param type 业务类型，如：chat,service,pdf
     * @param chatId 会话ID
     */
    void save(String type, String chatId);

    /**
     * 获取会话ID列表
     * @param type 业务类型，如：chat,service,pdf
     * @return 会话ID列表
     */
    List<String> getChartIds(String type);
}
