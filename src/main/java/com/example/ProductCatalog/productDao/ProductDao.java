package com.example.ProductCatalog.productDao;

import com.example.ProductCatalog.model.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(Long id);

    Product getProductByName(String name);

    List<Product> getAll();

    void saveProduct(Product product);

    void deleteProduct(Long id);

    void updateProduct(Product product);

}
