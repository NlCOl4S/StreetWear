package com.streetwear.backend.mapper;

import com.streetwear.backend.dto.cart.CartItemResponseDTO;
import com.streetwear.backend.dto.cart.CartResponseDTO;
import com.streetwear.backend.entity.Cart;
import java.util.List;

public class CartMapper {

    public static CartResponseDTO toResponseDTO(Cart cart) {

        List<CartItemResponseDTO> items = cart.getItems()
                .stream()
                .map(item -> new CartItemResponseDTO(
                        item.getId(),
                        item.getProduct().getId(),
                        item.getQuantity()
                ))
                .toList();

        return new CartResponseDTO(
                cart.getId(),
                cart.getUser().getId(),
                items
        );

    }

}
