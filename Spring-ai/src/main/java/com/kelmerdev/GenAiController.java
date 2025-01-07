package com.kelmerdev;

import com.kelmerdev.ImageGenRequest;
import org.springframework.ai.image.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class GenAiController {

    private final ImageModel imageModel;

    public GenAiController(@Qualifier("imagemodel") ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @GetMapping("/generate")
    public String imageGen(@RequestBody ImageGenRequest imageGenRequest){
        ImageOptions options = ImageOptionsBuilder.builder()
                .withModel("dall-e-3")
                .build();

        ImagePrompt imagePrompt = new ImagePrompt(imageGenRequest.prompt(), options);

        System.out.println("ImageModel - STARTED!!! - " + imageGenRequest.prompt());
        ImageResponse response = imageModel.call(imagePrompt);
        System.out.println("ImageModel - DONE!!! " + response);

        return "redirect:" + response.getResult().getOutput().getUrl();
    }
}
