package com.streetwear.backend.dto.cart;

public record CartItemResponseDTO (
        Long id,
        Long productId,
        int quantity
){
}
