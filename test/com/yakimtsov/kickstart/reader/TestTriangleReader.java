package com.yakimtsov.kickstart.reader;

import com.yakimtsov.kickstart.exception.IncorrectFileException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Ivan on 21.01.2018.
 */
public class TestTriangleReader {
    TriangleReader triangleReader = new TriangleReader();
    File file;
    File emptyFile;

    @BeforeClass
    public void setUp() {
        file = new File("test_data.txt");
        emptyFile = new File("empty_test_data.txt");

        List<String> lines = Arrays.asList("1.0 1.0 0.0 0.0 2.0 2.0",
                "3.0 2.0", "4.0 4.0", "1.0 1.0 0.0 0.0 1.0 5.0");
        try {
            if(file.createNewFile()){
                Path path = Paths.get(file.getPath());
                Files.write(path , lines, Charset.forName("UTF-8"));
            }

            emptyFile.createNewFile();

        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @AfterClass
    public void clear() {
        file.delete();
        emptyFile.delete();
    }

    @Test
    public void readPositive() {
        List<String> input = new ArrayList<>();
        try {
            input = triangleReader.read(file.getAbsolutePath());
        } catch (IncorrectFileException e) {
            fail(e.getMessage());
        }

        assertEquals(4, input.size());
    }

    @Test(expectedExceptions = IncorrectFileException.class)
    public void readEmptyFile() throws IncorrectFileException {
        triangleReader.read(emptyFile.getAbsolutePath());
    }

    @Test(expectedExceptions = IncorrectFileException.class)
    public void readNonexistedFile() throws IncorrectFileException {
        triangleReader.read("incorrect_file_name");
    }
}
