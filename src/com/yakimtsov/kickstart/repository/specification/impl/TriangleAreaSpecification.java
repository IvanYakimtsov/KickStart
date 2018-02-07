package com.yakimtsov.kickstart.repository.specification.impl;

import com.yakimtsov.kickstart.action.TriangleUtil;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.repository.specification.TriangleSpecification;

/**
 * Created by Ivan on 30.01.2018.
 */
public class TriangleAreaSpecification implements TriangleSpecification {
    private double triangleAreaMin;
    private double triangleAreaMax;

    public TriangleAreaSpecification(double triangleAreaMin, double triangleAreaMax) {
        this.triangleAreaMin = triangleAreaMin;
        this.triangleAreaMax = triangleAreaMax;
    }


    @Override
    public boolean specified(Triangle triangle) {
        double area = TriangleUtil.calculateTriangleArea(triangle);
        return area >= triangleAreaMin && area <= triangleAreaMax;
    }
}
