package com.yakimtsov.kickstart.observer;

import com.yakimtsov.kickstart.entity.Triangle;

/**
 * Created by Ivan on 28.01.2018.
 */
public interface TriangleObserver {
    void onTriangleChange(Triangle triangle);
}
