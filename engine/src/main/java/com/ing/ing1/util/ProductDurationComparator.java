package com.ing.ing1.util;

import com.ing.ing1.dto.Product;

import java.util.Comparator;

/**
 * Created by ggkekas on 20/11/15.
 */
public class ProductDurationComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o2.getDuration() - o1.getDuration();
    }
}
