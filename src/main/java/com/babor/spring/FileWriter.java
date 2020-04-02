package com.babor.spring;

public class FileWriter implements LogWriter {
    public void write(String text) {
        System.out.println("==== File Writer ==== " + text);
    }
}
