package com.streetwear.backend.service;

import com.streetwear.backend.entity.Product;
import com.streetwear.backend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@Service
@AllArgsConstructor


public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private ProductRepository productRepository;

    @Transactional
    public Product addProduct(Product product) {

        log.info("\n================================" +
                "\nProducto creado:" +
                "\nNombre: {}" +
                "\nPrecio: {}" +
                "\nStock: {}" +
                "\n================================", product.getName(), product.getPrice(), product.getStock());
        return productRepository.save(product);
    }

    public Product getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        log.info("\n================================" +
                "\nProducto encontrado:" +
                "\nNombre: {}" +
                "\nPrecio: {}" +
                "\n================================", product.getName(), product.getPrice());
        return product;
    }

    public List<Product> searchByName(String name) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        log.info("\n================================" +
                "\nProductos encontrados: {}" +
                "\nBusqueda: {}" +
                "\n================================", products.size(), name);
        return products;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
}