package com.dmslob.spring.core.di;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileSystemApplicationContextReader {

    private String file;

    public FileSystemApplicationContextReader(String file) {
        this.file = file;
    }

    public List<String> readLines() throws IOException {
        return Files.readAllLines(new File(file).toPath());
    }
}
