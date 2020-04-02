package com.babor.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Logger {
    private ConsoleWriter consoleWriter;
    private LogWriter fileWriter;

    @Resource
    public void setConsoleWriter(ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    @Resource(name = "demoFileWriter")
    public void setFileWriter(LogWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void writeConsole(String text) {
        consoleWriter.write(text);
    }

    public void writeFile(String text) {
        fileWriter.write(text);
    }

    @PostConstruct
    public void init() {
        System.out.println("Logger Created : ");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Logger Destroyed :");
    }
}
