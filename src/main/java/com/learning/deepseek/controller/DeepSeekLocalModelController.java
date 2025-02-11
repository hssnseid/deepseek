package com.learning.deepseek.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekLocalModelController {

    private final ChatClient chatClient;



    public DeepSeekLocalModelController(@Qualifier("OllamaChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    // this end point uses the deep seek model on local machine to process and answer any request
    @GetMapping("/deepSeekLocal/{m}")
    public String chat(@PathVariable String m){
        return chatClient
                .prompt()
                .user(m)
                .call().content();
    }

    @GetMapping("/HelloDeepSeek")
    public String helloDeepSeek(){
        return "Hello Deep Seek!!!";
    }
}
