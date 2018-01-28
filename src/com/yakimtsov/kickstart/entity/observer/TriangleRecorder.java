package com.yakimtsov.kickstart.entity.observer;

import com.sun.istack.internal.NotNull;
import com.yakimtsov.kickstart.action.TriangleUtil;
import com.yakimtsov.kickstart.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Ivan on 28.01.2018.
 */
public final class TriangleRecorder implements TriangleObserver {
    private static TriangleRecorder instance;
    private Map<Long, ParametersHolder> triangleParameters = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger();

    private TriangleRecorder() {

    }

    public static TriangleRecorder getInstance() {
        if (instance == null) {
            instance = new TriangleRecorder();
        }
        return instance;
    }

    @Override
    public void onTriangleChange(@NotNull Triangle triangle) {
        double perimeter = TriangleUtil.findTrianglePerimeter(triangle);
        double area = TriangleUtil.findTriangleArea(triangle);
        ParametersHolder parametersHolder = new ParametersHolder(perimeter, area);
        triangleParameters.put(triangle.getId(), parametersHolder);
    }

    public double getTriangleArea(long triangleId) {
        if (triangleParameters.containsKey(triangleId)) {
            ParametersHolder parametersHolder = triangleParameters.get(triangleId);
            return parametersHolder.area;
        } else {
            return 0;
        }
    }

    public double getTrianglePerimeter(long triangleId) {
        if (triangleParameters.containsKey(triangleId)) {
            ParametersHolder parametersHolder = triangleParameters.get(triangleId);
            return parametersHolder.perimeter;
        } else {
            return 0;
        }
    }


    private class ParametersHolder {
        private double perimeter;
        private double area;

        private ParametersHolder(double perimeter, double area) {
            this.perimeter = perimeter;
            this.area = area;
        }

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        LOGGER.log(Level.ERROR, "Tried to clone singleton object");
        throw new CloneNotSupportedException("Tried to clone singleton object");
    }
}
