package com.streetwear.backend.service;

import com.streetwear.backend.entity.Product;
import com.streetwear.backend.exception.ProductNotFoundException;
import com.streetwear.backend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> searchByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional
    public Product updateProduct(Long id, Product product){
        return productRepository.findById(id)
                .map(product1 -> {
                    product1.setName(product.getName());
                    product1.setDescription(product.getDescription());
                    product1.setPrice(product.getPrice());
                    product1.setCategory(product.getCategory());
                    return productRepository.save(product1);

                })
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }

}