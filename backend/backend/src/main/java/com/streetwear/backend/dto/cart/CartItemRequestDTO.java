package com.streetwear.backend.dto.cart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CartItemRequestDTO (
        @NotNull Long productId,
        @Positive int quantity
){

}
