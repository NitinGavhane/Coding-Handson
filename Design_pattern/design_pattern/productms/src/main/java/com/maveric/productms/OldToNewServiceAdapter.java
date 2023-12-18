package com.maveric.productms;
import java.util.List;
import java.util.stream.Collectors;

public class OldToNewServiceAdapter implements INewProductService {
    private final IOldProductService oldService;

    public OldToNewServiceAdapter(IOldProductService oldService) {
        this.oldService = oldService;
    }

    @Override
    public ProductDetails getProductById(long id) {
        Product product = oldService.findProductById(id);
        if (product != null) {
            // Map Product to ProductDetails
            return new ProductDetails(product.getName(), product.getPrice());
        } else {
            return null;
        }
    }

    @Override
    public List<ProductDetails> fetchAllProducts() {
        List<Product> products = oldService.getAll();
        return products.stream()
                .map(product -> new ProductDetails(product.getName(), product.getPrice()))
                .collect(Collectors.toList());
    }
}