package com.yakimtsov.kickstart.action;

import com.yakimtsov.kickstart.entity.Point;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.exception.InvalidParametersException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Ivan on 21.01.2018.
 */
public class TestTriangleUtil {

    @Test
    public void findTrianglePerimeterTest1(){
        Point firstPoint = new Point(0,0);
        Point secondPoint = new Point(0,2);
        Point thirdPoint = new Point(3,0);
        try {
            Triangle triangle = new Triangle(firstPoint,secondPoint,thirdPoint);
            double result = TriangleUtil.findTrianglePerimeter(triangle);
            assertEquals(result,8.605,0.01);
        } catch (InvalidParametersException e) {
            fail();
        }
    }

    @Test
    public void findTrianglePerimeterTest2(){
        Point firstPoint = new Point(1,1);
        Point secondPoint = new Point(-1,1);
        Point thirdPoint = new Point(0,-1);
        try {
            Triangle triangle = new Triangle(firstPoint,secondPoint,thirdPoint);
            double result = TriangleUtil.findTrianglePerimeter(triangle);
            assertEquals(result,6.472,0.01);
        } catch (InvalidParametersException e) {
            fail();
        }
    }

    @Test
    public void findSideSizeTest1(){
        Point firstPoint = new Point(0,0);
        Point secondPoint = new Point(0,2);
        double result = TriangleUtil.findSideSize(firstPoint,secondPoint);
        assertEquals(result,2,0.01);
    }

    @Test
    public void findSideSizeTest2(){
        Point firstPoint = new Point(0,-1);
        Point secondPoint = new Point(-1,1);
        double result = TriangleUtil.findSideSize(firstPoint,secondPoint);
        assertEquals(result,2.236,0.01);
    }


    @Test
    public void isRightTriangleTest1(){
        Point firstPoint = new Point(0,0);
        Point secondPoint = new Point(0,2);
        Point thirdPoint = new Point(3,0);
        try {
            Triangle triangle = new Triangle(firstPoint,secondPoint,thirdPoint);
            boolean condition = TriangleUtil.isRightTriangle(triangle);
            Assert.assertEquals(condition,true);
        } catch (InvalidParametersException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void isRightTriangleTest2(){
        Point firstPoint = new Point(0,0);
        Point secondPoint = new Point(0,-2);
        Point thirdPoint = new Point(-4,0);
        try {
            Triangle triangle = new Triangle(firstPoint,secondPoint,thirdPoint);
            boolean condition = TriangleUtil.isRightTriangle(triangle);
            Assert.assertEquals(condition,true);
        } catch (InvalidParametersException e) {
            Assert.fail();
        }
    }

    @Test
    public void isRightTriangleTestNegative(){
        Point firstPoint = new Point(1,1);
        Point secondPoint = new Point(-1,-1);
        Point thirdPoint = new Point(2,-1);
        try {
            Triangle triangle = new Triangle(firstPoint,secondPoint,thirdPoint);
            boolean condition = TriangleUtil.isRightTriangle(triangle);
            Assert.assertEquals(condition,false);
        } catch (InvalidParametersException e) {
            Assert.fail();
        }
    }


    @Test
    public void findTriangleAreaTest1(){
        Point firstPoint = new Point(0,0);
        Point secondPoint = new Point(0,2);
        Point thirdPoint = new Point(3,0);
        try {
            Triangle triangle = new Triangle(firstPoint,secondPoint,thirdPoint);
            double result = TriangleUtil.findTriangleArea(triangle);
            assertEquals(result,3,0.00001);
        } catch (InvalidParametersException e) {
            fail();
        }
    }


    @Test
    public void findTriangleAreaTest2(){
        Point firstPoint = new Point(0,0);
        Point secondPoint = new Point(0,-2);
        Point thirdPoint = new Point(-4,0);
        try {
            Triangle triangle = new Triangle(firstPoint,secondPoint,thirdPoint);
            double result = TriangleUtil.findTriangleArea(triangle);
            assertEquals(4,result,0.00001);
        } catch (InvalidParametersException e) {
            fail();
        }
    }

    @Test
    public void findTriangleAreaTest3(){
        Point firstPoint = new Point(1,1);
        Point secondPoint = new Point(-1,1);
        Point thirdPoint = new Point(0,-1);
        try {
            Triangle triangle = new Triangle(firstPoint,secondPoint,thirdPoint);
            double result = TriangleUtil.findTriangleArea(triangle);
            assertEquals(2,result,0.00001);
        } catch (InvalidParametersException e) {
            fail();
        }
    }

    @Test
    public void isPointsTriangleTestNegative(){
        Point point1 = new Point(1,1);
        Point point2 = new Point(0,0);
        Point point3 = new Point(3,3);
        boolean condition = TriangleUtil.isPointsTriangle(point1,point2,point3);
        assertEquals(condition,false);
    }

    @Test
    public void isPointsTriangleTestPoisive(){
        Point point1 = new Point(1,1);
        Point point2 = new Point(0,0);
        Point point3 = new Point(1,5);
        boolean condition = TriangleUtil.isPointsTriangle(point1,point2,point3);
        assertEquals(condition,true);
    }

    @Test
    public void triangleTest2(){
        Point point1 = new Point(1,1);
        Point point2 = new Point(0,0);
        Point point3 = new Point(-1,5);
        boolean condition = TriangleUtil.isPointsTriangle(point1,point2,point3);
        assertEquals(condition,true);
    }
}
