package com.streetwear.backend.dto.product;

import java.math.BigDecimal;

public record ProductResponseDTO (
         Long id,
         String name,
         String description,
         BigDecimal price,
         int stock,
         String size,
         String category

){
}
