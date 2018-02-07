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

        Point firstPoint = new Point(triangleParameters[Coordinates.X1.ordinal()],
                triangleParameters[Coordinates.Y1.ordinal()]);
        Point secondPoint = new Point(triangleParameters[Coordinates.X2.ordinal()],
                triangleParameters[Coordinates.Y2.ordinal()]);
        Point thirdPoint = new Point(triangleParameters[Coordinates.X3.ordinal()],
                triangleParameters[Coordinates.Y3.ordinal()]);

        Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);

        return triangle;
    }

    private enum Coordinates {
        X1, Y1, X2, Y2, X3, Y3
    }
}
