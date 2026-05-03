package com.streetwear.backend.controller;

import com.streetwear.backend.entity.Cart;
import com.streetwear.backend.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{cedula}")
    public Cart getCart(@PathVariable Long cedula) {
        return cartService.getCart(cedula);
    }

    @PostMapping("/{cedula}/add")
    public Cart addProduct(@PathVariable Long cedula, @RequestBody Map<String, Integer> body) {
        Long productId = Long.valueOf(body.get("productId"));
        int quantity = body.get("quantity");
        return cartService.addProduct(cedula, productId, quantity);
    }

    @DeleteMapping("/{cedula}/item/{itemId}")
    public Cart removeItem(@PathVariable Long cedula, @PathVariable Long itemId) {
        return cartService.removeItem(cedula, itemId);
    }

    @GetMapping("/{cedula}/total")
    public BigDecimal getTotal(@PathVariable Long cedula) {
        return cartService.calculateTotal(cedula);
    }
}