package com.aichatbot.service;

import com.aichatbot.client.ChatClient;
import com.aichatbot.dto.ChatRequest;
import com.aichatbot.dto.ChatResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatClient chatClient;

    @Value("${spring.ai.openai.chat.options.model}")
    private String modelName;

    public ChatResponse generateResponse(ChatRequest request) {
        if (request.getMessage() == null || request.getMessage().trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }

        log.info("Generating response for message: {}", request.getMessage());

        String aiResponse = chatClient.prompt()
                .user(request.getMessage())
                .call()
                .content();

        log.info("Response generated successfully using model: {}", modelName);

        return ChatResponse.builder()
                .response(aiResponse)
                .model(modelName)
                .timestamp(System.currentTimeMillis())
                .build();
    }
}
