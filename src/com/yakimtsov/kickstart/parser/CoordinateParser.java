package com.yakimtsov.kickstart.parser;
import com.yakimtsov.kickstart.exception.InvalidParametersException;
import com.yakimtsov.kickstart.validator.TriangleValidator;

/**
 * Created by Ivan on 20.01.2018.
 */
public class CoordinateParser {
    private final String SEPARATOR = "\\s";
    private TriangleValidator triangleValidator = new TriangleValidator();



    public double[] parseCoordinates(String triangleInput) throws InvalidParametersException {
        if (!triangleValidator.isValidInput(triangleInput)) {
            throw new InvalidParametersException("invalid input");
        }
        String[] integerStrings = triangleInput.split(SEPARATOR);
        double[] doubles = new double[integerStrings.length];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Double.parseDouble(integerStrings[i]);
        }

        return doubles;

    }

}
