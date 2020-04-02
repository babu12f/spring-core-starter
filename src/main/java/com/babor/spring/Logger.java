package com.babor.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

@Component
public class Logger {
    private ConsoleWriter consoleWriter;
    private LogWriter fileWriter;

    @Inject
    public void setConsoleWriter(ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    @Inject
    @Named( value = "filewriter")
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
