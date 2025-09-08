package com.learn.springai.entity.vo;

import lombok.Data;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.MessageType;

/**
 * @author lianshun
 * 2025/9/6 下午7:16
 */
@Data
public class MessageVo {
    private String role;
    private String content;

    public MessageVo(Message message) {
        MessageType messageType = message.getMessageType();
        switch (messageType) {
            case USER -> role = "user";
            case ASSISTANT ->  role = "assistant";
            default -> role = "";
        }
        this.content = message.getText();
    }
}
