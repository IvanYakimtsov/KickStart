package com.yakimtsov.kickstart.repository.impl;

import com.yakimtsov.kickstart.action.TriangleUtil;
import com.yakimtsov.kickstart.entity.Point;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.exception.InvalidParametersException;
import com.yakimtsov.kickstart.repository.specification.TriangleSpecification;
import com.yakimtsov.kickstart.repository.specification.impl.TriangleAreaSpecification;
import com.yakimtsov.kickstart.repository.specification.impl.TrianglePerimeterSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Ivan on 05.02.2018.
 */
public class RepositoryTest {
    Triangle triangle1;
    Triangle triangle2;
    Triangle triangle3;
    Triangle triangle4;


    @BeforeClass
    public void setUp() {
        try {
            triangle1 = new Triangle(new Point(0, 0), new Point(4, 0), new Point(2, Math.sqrt(12)));
            triangle2 = new Triangle(new Point(0, 3), new Point(4, 0), new Point(0, 0));
            triangle3 = new Triangle(new Point(0, 1), new Point(2, 0), new Point(5, 5));
            triangle4 = new Triangle(new Point(-1, 1), new Point(0, 1), new Point(1, 0));
        } catch (InvalidParametersException e) {
            fail(e.getMessage());
        }
    }

    @AfterClass
    public void dispose() {
        Repository.getInstance().delete(triangle1);
        Repository.getInstance().delete(triangle2);
        Repository.getInstance().delete(triangle3);
        Repository.getInstance().delete(triangle4);
    }

    @Test
    public void queryAreaSpecification() {
        TriangleSpecification specification = new TriangleAreaSpecification(4, 6);
        List<Triangle> actualList = Repository.getInstance().query(specification);

        int expectedSize = 1;

        assertEquals(actualList.size(), expectedSize);
    }

    @Test
    public void queryTrianglePerimeterSpecification() {
        TriangleSpecification specification = new TrianglePerimeterSpecification(11, 13);

        List<Triangle> actualList = Repository.getInstance().query(specification);

        int expectedSize = 2;

        assertEquals(actualList.size(), expectedSize);
    }

    @Test
    public void sort() {
        Repository.getInstance().sort(Comparator.comparingDouble(TriangleUtil::calculateTriangleArea)
                .thenComparing(Comparator.comparingDouble(TriangleUtil::calculateTrianglePerimeter)));

        List<Triangle> triangles = Repository.getInstance().getTriangleList();
        Triangle actualTriangle = triangles.get(triangles.size() - 1);

        assertEquals(actualTriangle, triangle1);
    }
}
