package com.yakimtsov.kickstart.creator;

import com.yakimtsov.kickstart.entity.Point;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.exception.InvalidParametersException;

/**
 * Created by Ivan on 27.01.2018.
 */
public class TriangleCreator {

    private final int AMOUNT_OF_PARAMETERS = 6;

    public Triangle createTriangle(double[] triangleParameters) throws InvalidParametersException {
        if (triangleParameters.length != AMOUNT_OF_PARAMETERS) {
            throw new InvalidParametersException("invalid parameters");
        }

        Point firstPoint = new Point(triangleParameters[0],triangleParameters[1]);
        Point secondPoint = new Point(triangleParameters[2],triangleParameters[3]);
        Point thirdPoint = new Point(triangleParameters[4],triangleParameters[5]);

        return new Triangle(firstPoint,secondPoint,thirdPoint);
    }
}
