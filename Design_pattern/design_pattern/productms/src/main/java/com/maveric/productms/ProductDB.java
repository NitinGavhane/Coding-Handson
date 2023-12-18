package com.maveric.productms;

import java.util.HashMap;
import java.util.Map;

public class ProductDB {
    private static Map<Long, Product>productMap;
    static {
        productMap=new HashMap<>();
        productMap.put(1l,new Product(1,"galaxy",20000,"phone","samsung"));
        productMap.put(2l,new Product(2,"razr",50000,"phone",".motorolla"));
    }

    public static Map<Long,Product>getStore(){
       return productMap;
    }
}
