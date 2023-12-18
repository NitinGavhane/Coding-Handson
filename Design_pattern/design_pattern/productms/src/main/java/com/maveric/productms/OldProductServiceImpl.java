package com.maveric.productms;

import java.util.ArrayList;
import java.util.List;

public class OldProductServiceImpl implements IOldProductService {

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(ProductDB.getStore().values());
    }

    @Override
    public Product findProductById(long id) {
        return ProductDB.getStore().get(id);
    }
}
