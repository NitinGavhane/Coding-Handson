package com.maveric.productms;


import java.util.List;

public interface INewProductService {

    ProductDetails getProductById(long id);

    List<ProductDetails> fetchAllProducts();

}
