package com.yakimtsov.kickstart.observer;

import com.yakimtsov.kickstart.action.TriangleUtil;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.storage.TriangleStorage;

/**
 * Created by Ivan on 30.01.2018.
 */
public class TriangleRecorder implements TriangleObserver{

    @Override
    public void onTriangleChange(Triangle triangle) {
        double perimeter = TriangleUtil.calculateTrianglePerimeter(triangle);
        double area = TriangleUtil.calculateTriangleArea(triangle);
        TriangleStorage.ParametersHolder parametersHolder = new TriangleStorage.ParametersHolder(perimeter, area);
        TriangleStorage.getInstance().addTriangleParameters(triangle.getId(), parametersHolder);
    }
}
