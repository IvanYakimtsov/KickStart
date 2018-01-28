package com.yakimtsov.kickstart.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ivan on 20.01.2018.
 */
public class TriangleValidator {
    private final String VALID_TRIANGLE_INPUT = "^(\\s*-?\\d+\\.\\d+\\s-?\\d+\\.\\d+){3}\\s*$";
    public boolean isValidInput(String triangleInput) {
        Pattern pattern = Pattern.compile(VALID_TRIANGLE_INPUT);
        Matcher matcher = pattern.matcher(triangleInput);
        return matcher.matches();
    }
}
