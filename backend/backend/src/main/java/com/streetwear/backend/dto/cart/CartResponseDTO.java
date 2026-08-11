package com.streetwear.backend.dto.cart;

import java.util.List;

public record CartResponseDTO (
        Long id,
        Long cedula,
        List<CartItemResponseDTO> items
){

}
