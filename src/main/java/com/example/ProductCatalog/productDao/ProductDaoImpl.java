package com.example.ProductCatalog.productDao;

import com.example.ProductCatalog.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product getProductById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product getProductByName(String name) {
        TypedQuery<Product> productTypedQuery = entityManager.createQuery(
                "select p from Product p where p.product_description = :name", Product.class);
        productTypedQuery.setParameter("name", name);
        return productTypedQuery.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public void saveProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void deleteProduct(Long id) {
        entityManager.createQuery("delete from Product p where p.id = : id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }
}
