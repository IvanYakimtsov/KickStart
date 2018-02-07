package com.yakimtsov.kickstart.parser;


import com.yakimtsov.kickstart.exception.InvalidParametersException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Ivan on 21.01.2018.
 */
public class CoordinateParserTest {

    CoordinateParser coordinateParser = new CoordinateParser();


    @Test(expectedExceptions = InvalidParametersException.class)
    public void parseCoordinatesWrongInputTest() throws InvalidParametersException {
        String input = "0.0 0.0 1.0 1*0 2.0 2.0";
        coordinateParser.parseCoordinates(input);
    }




    @Test
    public void parseCoordinatesPositive() {
        String input = "-1.0 -2.0 1.0 2.0 3.0 4.0";
        double[] expectedCoordinates = {-1,-2,1,2,3,4};
        try {
            double[] actualCoordinates= coordinateParser.parseCoordinates(input);
            assertEquals(expectedCoordinates, actualCoordinates);
        } catch (InvalidParametersException e) {
            fail("wrong parameters");
        }

    }
}
