package com.babor.spring;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter implements LogWriter {
    public void write(String text) {
        System.out.println("==== Console Writer ==== " + text);
    }
}
