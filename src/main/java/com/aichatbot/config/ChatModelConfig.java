package com.aichatbot.config;

import com.aichatbot.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatModelConfig {

  @Bean
  public ChatClient chatClient(
      @Value("${spring.ai.openai.api-key}") String apiKey,
      @Value("${spring.ai.openai.base-url}") String baseUrl,
      @Value("${spring.ai.openai.chat.options.model}") String model
  ) {
    OpenAiApi openAiApi = OpenAiApi.builder()
        .baseUrl(baseUrl)
        .apiKey(apiKey)
        .build();

    OpenAiChatOptions options = OpenAiChatOptions.builder()
        .model(model)
        .temperature(0.7)
        .build();

    var chatModel = OpenAiChatModel.builder()
        .openAiApi(openAiApi)
        .defaultOptions(options)
        .build();

    return new ChatClient(chatModel);
  }
}
