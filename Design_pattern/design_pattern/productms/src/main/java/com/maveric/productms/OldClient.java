package com.maveric.productms;

import java.util.List;

public class OldClient {
    private IOldProductService service;

    public OldClient(IOldProductService service){
        this.service=service;
    }

    public void displayAllProducts(){
       List<Product> products= service.getAll();
       products.stream().forEach(System.out::println);
    }

    public void displayProductById(long id){
        Product product=service.findProductById(id);
        System.out.println(product);
    }

}
