package com.yakimtsov.kickstart.entity.observer;

/**
 * Created by Ivan on 28.01.2018.
 */
public interface ObservableTriangle {
    public void addObserver(TriangleObserver triangleObserver);
    public void removeObserver(TriangleObserver triangleObserver);
    public void notifyObservers();
}
