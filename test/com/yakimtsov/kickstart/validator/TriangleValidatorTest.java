package com.yakimtsov.kickstart.validator;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;


/**
 * Created by Ivan on 21.01.2018.
 */
public class TriangleValidatorTest {
    TriangleValidator triangleValidator = new TriangleValidator();
    @Test
    public void isValidInputPositive(){
        boolean condition = triangleValidator.isValidInput("-1.0 -2.0 1.0 2.0 3.0 4.0");
        assertEquals(condition,true);
    }

    @Test
    public void isValidInputNegative(){
        boolean condition = triangleValidator.isValidInput("-1.0 -2*2 1.0 2.0 3.0 4.0");
        assertEquals(condition,false);
    }
}
