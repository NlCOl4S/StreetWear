package com.streetwear.backend.mapper;

import com.streetwear.backend.dto.product.ProductRequestDTO;
import com.streetwear.backend.dto.product.ProductResponseDTO;
import com.streetwear.backend.entity.Product;

public class ProductMapper {

    public static ProductResponseDTO toResponseDTO(Product product){
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getSize(),
                product.getCategory()
        );
    }

    public static Product toEntity(ProductRequestDTO dto){

                Product product = new Product();
                product.setName(dto.name());
                product.setDescription(dto.description());
                product.setPrice(dto.price());
                product.setStock(dto.stock());
                product.setSize(dto.size());
                product.setCategory(dto.category());

       return product;
    }
}
