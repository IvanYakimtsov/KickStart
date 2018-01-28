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
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 27.01.2018.
 */
public class ComplexTest {
    private static Logger logger = LogManager.getLogger();

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
            List<String> input = triangleReader.read("Data/test_input_data.txt");
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
