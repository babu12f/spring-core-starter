package com.babor.spring;

public class ConsoleWriter implements LogWriter {
    public void write(String text) {
        System.out.println("==== Console Writer ==== " + text);
    }
}
