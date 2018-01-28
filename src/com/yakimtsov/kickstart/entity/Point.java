package com.yakimtsov.kickstart.entity;

/**
 * Created by Ivan on 20.01.2018.
 */
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point" + " x = " + x + " y = " + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Point.class) {
            return false;
        }
        Point point = (Point) obj;
        return (this.x == point.x && this.y == point.y);
    }

    @Override
    public int hashCode() {
        int result = 17;
        long longBits = Double.doubleToLongBits(x + y);
        result = 37 * result + (int) (longBits - (longBits >>> 32));
        return result;

    }

}
