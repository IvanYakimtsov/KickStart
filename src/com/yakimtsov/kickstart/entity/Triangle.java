package com.yakimtsov.kickstart.entity;

import com.yakimtsov.kickstart.action.TriangleUtil;
import com.yakimtsov.kickstart.observer.ObservableTriangle;
import com.yakimtsov.kickstart.observer.TriangleObserver;
import com.yakimtsov.kickstart.observer.TriangleRecorder;
import com.yakimtsov.kickstart.repository.impl.Repository;
import com.yakimtsov.kickstart.exception.InvalidParametersException;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Ivan on 20.01.2018.
 */
public class Triangle implements ObservableTriangle {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private long id;
    private Set<TriangleObserver> triangleObservers = new HashSet<>();

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) throws InvalidParametersException {
        if (firstPoint == null || secondPoint == null || thirdPoint == null) {
            throw new InvalidParametersException("null is not available");
        }
        if (!TriangleUtil.isPointsTriangle(firstPoint, secondPoint, thirdPoint)) {
            throw new InvalidParametersException("Points are not triangle");
        }
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;

        addObserver(new TriangleRecorder());
        this.id = UUID.randomUUID().getMostSignificantBits();

        Repository.getInstance().add(this);
        notifyObservers();
    }

    public void setFirstPoint(Point firstPoint) throws InvalidParametersException {
        if (firstPoint == null) {
            throw new InvalidParametersException("null is not available");
        }
        if (TriangleUtil.isPointsTriangle(firstPoint, secondPoint, thirdPoint)) {
            this.firstPoint = firstPoint;
            notifyObservers();
        } else {
            throw new InvalidParametersException("points are not triangle");
        }
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setSecondPoint(Point secondPoint) throws InvalidParametersException {
        if (secondPoint == null) {
            throw new InvalidParametersException("null is not available");
        }
        if (TriangleUtil.isPointsTriangle(firstPoint, secondPoint, thirdPoint)) {
            this.secondPoint = secondPoint;
            notifyObservers();
        } else {
            throw new InvalidParametersException("points are not triangle");
        }
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setThirdPoint(Point thirdPoint) throws InvalidParametersException {
        if (thirdPoint == null) {
            throw new InvalidParametersException("null is not available");
        }
        if (TriangleUtil.isPointsTriangle(firstPoint, secondPoint, thirdPoint)) {
            this.thirdPoint = thirdPoint;
            notifyObservers();
        } else {
            throw new InvalidParametersException("points are not triangle");
        }
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public long getId() {
        return id;
    }


    @Override
    public void addObserver(TriangleObserver triangleObserver) {
        triangleObservers.add(triangleObserver);
    }

    @Override
    public void removeObserver(TriangleObserver triangleObserver) {
        triangleObservers.remove(triangleObserver);
    }

    @Override
    public void removeObservers() {
        triangleObservers.clear();
    }

    @Override
    public void notifyObservers() {
        for (TriangleObserver observer : triangleObservers) {
            observer.onTriangleChange(this);
        }
    }

    @Override
    public String toString() {
        return "Triangle " + firstPoint.toString() + " " + secondPoint.toString() + " " + thirdPoint.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        if (obj.getClass() != Triangle.class) {
            return false;
        }
        Triangle triangle = (Triangle) obj;
        return (this.firstPoint.equals(triangle.getFirstPoint()) && this.secondPoint.equals(triangle.getSecondPoint())
                && this.thirdPoint.equals(triangle.getThirdPoint()));
    }

    @Override
    public int hashCode() {
        return firstPoint.hashCode() + secondPoint.hashCode() + thirdPoint.hashCode();
    }

}
