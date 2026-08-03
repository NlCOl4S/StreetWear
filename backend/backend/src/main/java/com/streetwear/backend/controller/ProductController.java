package com.streetwear.backend.controller;

import com.streetwear.backend.dto.product.ProductRequestDTO;
import com.streetwear.backend.dto.product.ProductResponseDTO;
import com.streetwear.backend.entity.Product;
import com.streetwear.backend.mapper.ProductMapper;
import com.streetwear.backend.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        Product product = ProductMapper.toEntity(productRequestDTO);
        Product savedProduct = productService.addProduct(product);

        return ResponseEntity.ok(ProductMapper.toResponseDTO(savedProduct));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> products = productService.getAllProducts()
                .stream()
                .map(ProductMapper::toResponseDTO)
                .toList();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        return ResponseEntity.ok(ProductMapper.toResponseDTO(product));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDTO>> searchByName(@RequestParam String name) {
        List<ProductResponseDTO> products = productService.searchByName(name)
                .stream()
                .map(ProductMapper::toResponseDTO)
                .toList();

        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

}