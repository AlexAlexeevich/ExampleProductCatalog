package com.example.ProductCatalog.service;

import com.example.ProductCatalog.model.Product;
import com.example.ProductCatalog.productDao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    @Override
    @Transactional
    public Product getProductByName(String name) {
        return productDao.getProductByName(name);
    }


    @Override
    @Transactional
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productDao.deleteProduct(id);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}
