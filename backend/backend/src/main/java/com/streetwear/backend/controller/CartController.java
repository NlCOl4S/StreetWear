package com.streetwear.backend.controller;

import com.streetwear.backend.dto.cart.CartItemRequestDTO;
import com.streetwear.backend.dto.cart.CartResponseDTO;
import com.streetwear.backend.entity.Cart;
import com.streetwear.backend.mapper.CartMapper;
import com.streetwear.backend.service.CartService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{cedula}")
    public ResponseEntity<CartResponseDTO> getCart(@PathVariable Long cedula) {
        Cart cart =  cartService.getCart(cedula);

        return ResponseEntity.ok(CartMapper.toResponseDTO(cart));
    }

    @PostMapping("/{cedula}/items")
    public ResponseEntity<CartResponseDTO> addProduct(@PathVariable Long cedula, @Valid @RequestBody CartItemRequestDTO cartItemRequestDTO) {
        Long productId = cartItemRequestDTO.productId();
        int quantity = cartItemRequestDTO.quantity();
        Cart cart = cartService.addProduct(cedula,productId,quantity);

        return ResponseEntity.ok(CartMapper.toResponseDTO(cart));
    }

    @DeleteMapping("/{cedula}/items/{itemId}")
    public ResponseEntity<CartResponseDTO> removeItem(@PathVariable Long cedula, @PathVariable Long itemId) {
        Cart cart = cartService.removeItem(cedula, itemId);

        return ResponseEntity.ok(CartMapper.toResponseDTO(cart));
    }

    @GetMapping("/{cedula}/total")
    public ResponseEntity<BigDecimal> getTotal(@PathVariable Long cedula) {
        BigDecimal total =  cartService.calculateTotal(cedula);

        return ResponseEntity.ok(total);
    }
}