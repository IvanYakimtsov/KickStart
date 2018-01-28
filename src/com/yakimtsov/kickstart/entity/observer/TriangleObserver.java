package com.yakimtsov.kickstart.entity.observer;

import com.yakimtsov.kickstart.entity.Triangle;

/**
 * Created by Ivan on 28.01.2018.
 */
public interface TriangleObserver {
    public void onTriangleChange(Triangle triangle);
}
