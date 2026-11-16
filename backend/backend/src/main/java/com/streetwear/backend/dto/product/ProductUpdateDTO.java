package com.streetwear.backend.dto.product;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductUpdateDTO (
        @NotBlank String name,
        @NotBlank @Size(min = 3, message = "The description must have a minimum of 3 characters") String description,
        @NotNull @Positive BigDecimal price,
        @NotBlank String category
){
}
