package com.babor.spring;

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
}
