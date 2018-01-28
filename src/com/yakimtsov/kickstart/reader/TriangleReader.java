package com.yakimtsov.kickstart.reader;

import com.yakimtsov.kickstart.exception.IncorrectFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 * Created by Ivan on 20.01.2018.
 */

public class TriangleReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> read(String filename) throws IncorrectFileException {
        File file = new File(filename);
        List<String> lines;
        if (file.exists() && file.length() != 0) {
            try {
                lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                logger.log(Level.FATAL, e);
                throw new RuntimeException();
            }
        } else {
            throw new IncorrectFileException("wrong file");
        }
        return lines;
    }

}


