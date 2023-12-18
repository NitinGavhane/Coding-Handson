package com.maveric.productms;

import java.util.List;

public class NewClient {
    private INewProductService service;

    public NewClient(INewProductService service) {
        this.service = service;
    }

    public void displayAllProducts() {
        List<ProductDetails> products = service.fetchAllProducts();
        products.forEach(System.out::println);
    }

    public void displayProductById(long id) {
        ProductDetails product = service.getProductById(id);
        System.out.println(product);
    }
}

