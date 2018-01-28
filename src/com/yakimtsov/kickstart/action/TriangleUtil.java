package com.yakimtsov.kickstart.action;

import com.sun.istack.internal.NotNull;
import com.yakimtsov.kickstart.entity.Point;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.exception.InvalidParametersException;

/**
 * Created by Ivan on 20.01.2018.
 */
public class TriangleUtil {

    public static double findTrianglePerimeter(@NotNull Triangle triangle) {
        double firstSide = findSideSize(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSide = findSideSize(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSide = findSideSize(triangle.getThirdPoint(), triangle.getFirstPoint());
        return firstSide + secondSide + thirdSide;
    }


    public static double findSideSize(@NotNull Point firstPoint, @NotNull Point secondPoint) {
        double deltaX = Math.pow(secondPoint.getX() - firstPoint.getX(), 2);
        double deltaY = Math.pow(secondPoint.getY() - firstPoint.getY(), 2);
        return Math.sqrt(deltaX + deltaY);
    }

    public static boolean isRightTriangle(@NotNull Triangle triangle) {
        double firstSide = TriangleUtil.findSideSize(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSide = TriangleUtil.findSideSize(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSide = TriangleUtil.findSideSize(triangle.getThirdPoint(), triangle.getFirstPoint());

        boolean firstCondition = (firstSide == Math.hypot(secondSide, thirdSide));
        boolean secondCondition = (secondSide == Math.hypot(firstSide, thirdSide));
        boolean thirdCondition = (thirdSide == Math.hypot(firstSide, secondSide));

        return firstCondition || secondCondition || thirdCondition;
    }

    public static boolean isPointsTriangle(@NotNull Point firstPoint, @NotNull Point secondPoint, @NotNull Point thirdPoint) {
        if (firstPoint.equals(secondPoint)) return false;
        if (secondPoint.equals(thirdPoint)) return false;
        if (firstPoint.equals(thirdPoint)) return false;
        double firstVectorX = secondPoint.getX() - firstPoint.getY();
        double firstVectorY = secondPoint.getY() - firstPoint.getY();
        double secondVectorX = thirdPoint.getX() - firstPoint.getY();
        double secondVectorY = thirdPoint.getY() - firstPoint.getY();
        return (firstVectorX / secondVectorX) != (firstVectorY / secondVectorY);
    }

    public static double findTriangleArea(@NotNull Triangle triangle) {
        double halfPerimeter = TriangleUtil.findTrianglePerimeter(triangle) / 2;

        double firstSide = TriangleUtil.findSideSize(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSide = TriangleUtil.findSideSize(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSide = TriangleUtil.findSideSize(triangle.getThirdPoint(), triangle.getFirstPoint());

        return Math.sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide));
    }
}
