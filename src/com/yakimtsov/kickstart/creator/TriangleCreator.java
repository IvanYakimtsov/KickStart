package com.yakimtsov.kickstart.creator;

import com.yakimtsov.kickstart.entity.Point;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.exception.InvalidParametersException;

/**
 * Created by Ivan on 27.01.2018.
 */
public class TriangleCreator {

    private final int AMOUNT_OF_PARAMETERS = 6;

    public Triangle createTriangle(double[] parameters) throws InvalidParametersException {
        if (parameters.length != AMOUNT_OF_PARAMETERS) {
            throw new InvalidParametersException("invalid parameters");
        }

        Point firstPoint = new Point(parameters[0],parameters[1]);
        Point secondPoint = new Point(parameters[2],parameters[3]);
        Point thirdPoint = new Point(parameters[4],parameters[5]);

        return new Triangle(firstPoint,secondPoint,thirdPoint);
    }
}
