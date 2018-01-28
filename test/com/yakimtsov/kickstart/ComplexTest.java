package com.yakimtsov.kickstart;

import com.yakimtsov.kickstart.creator.TriangleCreator;
import com.yakimtsov.kickstart.entity.Point;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.exception.IncorrectFileException;
import com.yakimtsov.kickstart.exception.InvalidParametersException;
import com.yakimtsov.kickstart.parser.CoordinateParser;
import com.yakimtsov.kickstart.reader.TriangleReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ivan on 27.01.2018.
 */
public class ComplexTest {
    private static Logger logger = LogManager.getLogger();
    File file;

    @BeforeClass
    public void setUp() {
        file = new File("test_data.txt");

        List<String> lines = Arrays.asList("1.0 1.0 0.0 0.0 2.0 2.0",
                "3.0 2.0", "4.0 4.0", "1.0 1.0 0.0 0.0 1.0 5.0");
        try {
            if(file.createNewFile()){
                Path path = Paths.get(file.getPath());
                Files.write(path , lines, Charset.forName("UTF-8"));
            }

        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @AfterClass
    public void clear() {
        file.delete();
    }

    @Test
    public void complexTest1() {
        List<Triangle> expectedTriangleList = new ArrayList<>();
        Point point1 = new Point(1, 1);
        Point point2 = new Point(0, 0);
        Point point3 = new Point(1, 5);
        TriangleReader triangleReader = new TriangleReader();
        TriangleCreator triangleCreator = new TriangleCreator();
        CoordinateParser coordinateParser = new CoordinateParser();
        try {
            List<String> input = triangleReader.read(file.getAbsolutePath());
            List<Triangle> actualTriangleList = new ArrayList<>();
            Triangle expectedTriangle = new Triangle(point1,point2,point3);
            expectedTriangleList.add(expectedTriangle);

            for (String line : input) {
                try {
                    double[] coordinates = coordinateParser.parseCoordinates(line);
                    Triangle triangle = triangleCreator.createTriangle(coordinates);
                    actualTriangleList.add(triangle);
                } catch (InvalidParametersException e) {
                    logger.log(Level.WARN, e);
                }
            }
            assertEquals(expectedTriangleList,actualTriangleList);

        } catch (IncorrectFileException|InvalidParametersException e) {
            fail(e.getMessage());
        }
    }

}
