package com.yakimtsov.kickstart.repository;

import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.repository.specification.TriangleSpecification;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Ivan on 05.02.2018.
 */
public interface TriangleRepository {
     void add(Triangle triangle);
     void delete(Triangle triangle);
     List<Triangle> query(TriangleSpecification specification);
     void sort(Comparator<Triangle> comparator);
}
