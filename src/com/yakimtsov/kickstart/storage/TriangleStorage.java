package com.yakimtsov.kickstart.storage;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Ivan on 28.01.2018.
 */
public final class TriangleStorage {
    private static TriangleStorage instance;
    private Map<Long, ParametersHolder> triangleParameters = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger();

    private final int TRIANGLE_NOT_FOUND = -1;

    private TriangleStorage() {

    }

    public static TriangleStorage getInstance() {
        if (instance == null) {
            instance = new TriangleStorage();
        }
        return instance;
    }


    public void addTriangleParameters(long triangleId, ParametersHolder parametersHolder){
        triangleParameters.put(triangleId, parametersHolder);
    }

    public void deleteTriangleParameters(long triangleId){
        triangleParameters.remove(triangleId);
    }

    public double getTriangleArea(long triangleId) {
        if (triangleParameters.containsKey(triangleId)) {
            ParametersHolder parametersHolder = triangleParameters.get(triangleId);
            return parametersHolder.getArea();
        } else {
            return TRIANGLE_NOT_FOUND;
        }
    }

    public double getTrianglePerimeter(long triangleId) {
        if (triangleParameters.containsKey(triangleId)) {
            ParametersHolder parametersHolder = triangleParameters.get(triangleId);
            return parametersHolder.getPerimeter();
        } else {
            return TRIANGLE_NOT_FOUND;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        LOGGER.log(Level.ERROR, "Tried to clone singleton object");
        throw new CloneNotSupportedException("Tried to clone singleton object");
    }


    public static class ParametersHolder {
        private double perimeter;
        private double area;

        public ParametersHolder(double perimeter, double area) {
            this.perimeter = perimeter;
            this.area = area;
        }

        public double getPerimeter() {
            return perimeter;
        }

        public void setPerimeter(double perimeter) {
            this.perimeter = perimeter;
        }

        public double getArea() {
            return area;
        }

        public void setArea(double area) {
            this.area = area;
        }
    }
}
