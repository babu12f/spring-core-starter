package com.babor.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Logger {

//    @Autowired
    private ConsoleWriter consoleWriter;

//    @Autowired
    private FileWriter fileWriter;

    @Autowired
    public Logger(ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    public LogWriter getConsoleWriter() {
        return consoleWriter;
    }

//    @Autowired
    public void setConsoleWriter(ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    public LogWriter getFileWriter() {
        return fileWriter;
    }

    @Autowired
    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void writeConsole(String text) {
        consoleWriter.write(text);
    }

    public void writeFile(String text) {
        fileWriter.write(text);
    }
}
