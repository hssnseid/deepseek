package com.learning.deepseek.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekController {

    private final ChatClient chatClient;

    public DeepSeekController(@Qualifier("OpenAiChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }
 // this end point uses the deep seek model on site (https://deepseek.com) to process and answer any request
    @GetMapping("/deepSeek/{m}")
    public String chat(@PathVariable String m){
        return chatClient
                .prompt()
                .user(m)
                .call()
                .content();
    }
}
