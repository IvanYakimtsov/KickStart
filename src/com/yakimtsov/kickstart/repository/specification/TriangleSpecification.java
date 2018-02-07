package com.yakimtsov.kickstart.repository.specification;

import com.yakimtsov.kickstart.entity.Triangle;

/**
 * Created by Ivan on 30.01.2018.
 */
public interface TriangleSpecification {
    boolean specified(Triangle triangle);
}
