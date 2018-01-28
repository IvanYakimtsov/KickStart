package com.yakimtsov.kickstart.reader;

import com.yakimtsov.kickstart.exception.IncorrectFileException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Ivan on 21.01.2018.
 */
public class TestTriangleReader {
    TriangleReader triangleReader = new TriangleReader();

    @Test
    public void readPositive(){
        List<String> input = new ArrayList<>();
        try {
            input = triangleReader.read("Data/test_input_data.txt");
        } catch (IncorrectFileException e) {
            fail(e.getMessage());
        }

        assertEquals(4,input.size());
    }

    @Test(expectedExceptions = IncorrectFileException.class)
    public void readEmptyFile() throws IncorrectFileException {
            triangleReader.read("Data/test2_input_data.txt");
    }

    @Test(expectedExceptions = IncorrectFileException.class)
    public void readNonexistedFile() throws IncorrectFileException {
        triangleReader.read("Data/tet2_inputdata.txt");
    }
}
