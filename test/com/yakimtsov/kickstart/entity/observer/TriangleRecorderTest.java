package com.yakimtsov.kickstart.entity.observer;

import com.yakimtsov.kickstart.action.TriangleUtil;
import com.yakimtsov.kickstart.entity.Point;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.exception.InvalidParametersException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Ivan on 28.01.2018.
 */
public class TriangleRecorderTest {
    Triangle triangle;

    @BeforeClass
    public void setUp() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(0, 0);
        Point point3 = new Point(2, 0);
        try {
            triangle = new Triangle(point1, point2, point3);
        } catch (InvalidParametersException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void onTriangleChangePointChange() {
        try {
            triangle.setFirstPoint(new Point(1,2));
        } catch (InvalidParametersException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = InvalidParametersException.class)
    public void onTriangleChangeInvalidChangeTest1() throws InvalidParametersException {
        triangle.setFirstPoint(new Point(0,0));
    }

    @Test(expectedExceptions = InvalidParametersException.class)
    public void onTriangleChangeInvalidChangeTest2() throws InvalidParametersException {
        triangle.setFirstPoint(null);
    }

    @Test
    public void getTriangleAreaTest() {
        double expectedArea = TriangleUtil.findTriangleArea(triangle);
        double actualArea = TriangleRecorder.getInstance().getTriangleArea(triangle.getId());
        assertEquals(expectedArea, actualArea, 0.000001);
    }


    @Test
    public void getTrianglePerimeterTest() {
        double expectedArea = TriangleUtil.findTrianglePerimeter(triangle);
        double actualArea = TriangleRecorder.getInstance().getTrianglePerimeter(triangle.getId());
        assertEquals(expectedArea, actualArea, 0.000001);
    }
}
