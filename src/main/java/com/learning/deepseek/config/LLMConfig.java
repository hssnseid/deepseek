package com.learning.deepseek.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LLMConfig {

    @Bean
    public ChatClient OpenAiChatClient(OpenAiChatModel model){
        return ChatClient.create(model);
    }


    @Bean
    public ChatClient OllamaChatClient(OllamaChatModel model){
        return ChatClient.create(model);
    }
}
