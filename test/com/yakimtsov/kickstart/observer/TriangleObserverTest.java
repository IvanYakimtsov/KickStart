package com.yakimtsov.kickstart.observer;

import com.yakimtsov.kickstart.action.TriangleUtil;
import com.yakimtsov.kickstart.entity.Point;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.exception.InvalidParametersException;
import com.yakimtsov.kickstart.storage.TriangleStorage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Ivan on 28.01.2018.
 */
public class TriangleObserverTest {
    Triangle triangle;

    @BeforeClass
    public void setUp() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(0, 0);
        Point point3 = new Point(2, 0);
        try {
            triangle = new Triangle(point1, point2, point3);
            triangle.addObserver(new TriangleRecorder());
            triangle.notifyObservers();
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
        long triangleId = triangle.getId();
        double expectedArea = TriangleUtil.calculateTriangleArea(triangle);
        double actualArea = TriangleStorage.getInstance().getTriangleArea(triangleId);
        assertEquals(expectedArea,actualArea,0.00005);
    }

}
