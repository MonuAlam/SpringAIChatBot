package com.aichatbot.client;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;

public class ChatClient {

    private final ChatModel chatModel;
    private String userMessage;

    public ChatClient(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public PromptBuilder prompt() {
        return new PromptBuilder(this);
    }

    public class PromptBuilder {
        private final ChatClient client;

        public PromptBuilder(ChatClient client) {
            this.client = client;
        }

        public PromptBuilder user(String message) {
            client.userMessage = message;
            return this;
        }

        public CallBuilder call() {
            return new CallBuilder(client);
        }
    }

    public class CallBuilder {
        private final ChatClient client;

        public CallBuilder(ChatClient client) {
            this.client = client;
        }

        public String content() {
            Prompt prompt = new Prompt(new UserMessage(client.userMessage));
            return client.chatModel.call(prompt).getResult().getOutput().getText();
        }
    }
}
