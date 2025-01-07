package com.kelmerdev;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.openai.api.OpenAiImageApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiApplication.class, args);
    }


    @Bean
    ImageModel imagemodel(@Value("${spring.ai.openai.api-key]") String apiKey){
        return new OpenAiImageModel(new OpenAiImageApi(apiKey));
    }


    @Bean
    ChatModel chatModel(@Value("${spring.ai.openai.api-key}") String apiKey){
        return new OpenAiChatModel(new OpenAiApi(apiKey));
    }

}
