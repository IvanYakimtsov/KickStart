package com.yakimtsov.kickstart.creator;

import com.yakimtsov.kickstart.entity.Point;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.exception.InvalidParametersException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Ivan on 27.01.2018.
 */
public class TriangleCreatorTest {
    TriangleCreator triangleCreator = new TriangleCreator();

    @Test(expectedExceptions = InvalidParametersException.class)
    public void createTriangleWrongInputTest1() throws InvalidParametersException {
        double[] expectedCoordinates = {-1, -2, 1, 2, 3, 4, 2};
        triangleCreator.createTriangle(expectedCoordinates);
    }

    @Test(expectedExceptions = InvalidParametersException.class)
    public void createTriangleWrongInputTest2() throws InvalidParametersException {
        double[] expectedCoordinates = {-1, -2, 1, 2, 3};
        triangleCreator.createTriangle(expectedCoordinates);
    }

    @Test(expectedExceptions = InvalidParametersException.class)
    public void createTrianglePointsAreNotTriangle() throws InvalidParametersException {
        double[] expectedCoordinates = {-1, -2, 1, 2, -1, -2};
        triangleCreator.createTriangle(expectedCoordinates);
    }

    @Test
    public void createTrianglePositive() {
        double[] expectedCoordinates = {-1, -2, 1, 2, 3, 4};
        Point point1 = new Point(-1, -2);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(3, 4);
        try {
            Triangle expectedTriangle = new Triangle(point1, point2, point3);
            Triangle actualTriangle = triangleCreator.createTriangle(expectedCoordinates);
            assertEquals(expectedTriangle, actualTriangle);
        } catch (InvalidParametersException e) {
            fail(e.getMessage());
        }

    }
}
