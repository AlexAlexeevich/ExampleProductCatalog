package com.example.ProductCatalog.controller;

import com.example.ProductCatalog.model.Product;
import com.example.ProductCatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String findAll(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "product-catalog";
    }

    @GetMapping("/product-create")
    public String createProductForm(Product product) {
        return "product-create";
    }

    @PostMapping("/product-create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/product-show")
    public String showProductForm(Product product) {
        return "product-show";
    }

    @PostMapping("/product-show")
    public String showProduct(Product product, Model model) {
        Product resultProduct = productService.getProductByName(product.getProduct_description());
        model.addAttribute("resultProduct", resultProduct);
        return "product-show";
    }

    @GetMapping("product-delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/product-update/{id}")
    public String updateProduct(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-update";
    }

    @PostMapping("/product-update")
    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "redirect:/products";
    }
}
