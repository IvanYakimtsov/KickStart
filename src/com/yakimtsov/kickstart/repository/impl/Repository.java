package com.yakimtsov.kickstart.repository.impl;

import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.repository.TriangleRepository;
import com.yakimtsov.kickstart.repository.specification.TriangleSpecification;
import com.yakimtsov.kickstart.storage.TriangleStorage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ivan on 30.01.2018.
 */
public class Repository implements TriangleRepository{
    private static Repository instance;
    private static final Logger LOGGER = LogManager.getLogger();

    private List<Triangle> triangleList = new ArrayList<>();


    private Repository() {

    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public List<Triangle> getTriangleList() {
        return triangleList;
    }

    @Override
    public void add(Triangle triangle) {
        triangleList.add(triangle);
    }

    @Override
    public void delete(Triangle triangle) {
        triangle.removeObservers();
        triangleList.remove(triangle);
        TriangleStorage.getInstance().deleteTriangleParameters(triangle.getId());
    }

    @Override
    public List<Triangle> query(TriangleSpecification specification) {
        List<Triangle> correctTriangles = new ArrayList<>();

        for (Triangle triangle : triangleList) {
            if (specification.specified(triangle)) {
                correctTriangles.add(triangle);
            }
        }

        return correctTriangles;
    }

    @Override
    public void sort(Comparator<Triangle> comparator){
        triangleList.sort(comparator);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        LOGGER.log(Level.ERROR, "Tried to clone singleton object");
        throw new CloneNotSupportedException("Tried to clone singleton object");
    }
}
