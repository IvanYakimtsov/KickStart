package com.yakimtsov.kickstart.repository.specification.impl;

import com.yakimtsov.kickstart.action.TriangleUtil;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.repository.specification.TriangleSpecification;

/**
 * Created by Ivan on 05.02.2018.
 */
public class TrianglePerimeterSpecification implements TriangleSpecification {
    private double trianglePerimeterMin;
    private double trianglePerimeterMax;

    public TrianglePerimeterSpecification(double trianglePerimeterMin, double trianglePerimeterMax) {
        this.trianglePerimeterMin = trianglePerimeterMin;
        this.trianglePerimeterMax = trianglePerimeterMax;
    }


    @Override
    public boolean specified(Triangle triangle) {
        double perimeter = TriangleUtil.calculateTrianglePerimeter(triangle);
        return perimeter >= trianglePerimeterMin && perimeter <= trianglePerimeterMax;
    }
}
