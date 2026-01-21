package com.aichatbot.controller;

import com.aichatbot.dto.ChatRequest;
import com.aichatbot.dto.ChatResponse;
import com.aichatbot.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        log.debug("Received POST request with message: {}", request.getMessage());
        return ResponseEntity.ok(chatService.generateResponse(request));
    }

    @GetMapping
    public ResponseEntity<ChatResponse> chatWithQueryParam(@RequestParam(value = "message") String message) {
        log.debug("Received GET request with message: {}", message);
        ChatRequest request = new ChatRequest(message);
        return ResponseEntity.ok(chatService.generateResponse(request));
    }
}
