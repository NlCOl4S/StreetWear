package com.streetwear.backend.dto.product;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductRequestDTO (
        @NotBlank String name,
        @NotBlank @Size(min = 3, message = "The description have a minimum of 3 characters") String description,
        @NotNull @Positive BigDecimal price,
        @PositiveOrZero int stock,
        @NotBlank String size,
        @NotBlank String category
        ){
}
