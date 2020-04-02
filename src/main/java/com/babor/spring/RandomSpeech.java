package com.babor.spring;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomSpeech {
    private static String[] texts = {
            "Who goes there?",
            "Good Morning!",
            "Feed me cookies",
            null
    };

    public String getText() {
        Random random = new Random();

        return texts[random.nextInt(texts.length)];
    }
}
