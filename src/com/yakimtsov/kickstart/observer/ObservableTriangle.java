package com.yakimtsov.kickstart.observer;


/**
 * Created by Ivan on 28.01.2018.
 */
public interface ObservableTriangle {
    void addObserver(TriangleObserver triangleObserver);
    void removeObserver(TriangleObserver triangleObserver);
    void removeObservers();
    void notifyObservers();
}
