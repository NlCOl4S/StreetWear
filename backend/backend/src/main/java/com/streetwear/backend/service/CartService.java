package com.streetwear.backend.service;

import com.streetwear.backend.entity.*;
import com.streetwear.backend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CartService {


    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    private Cart getOrCreateCart(Long cedula) {
        return cartRepository.findByUserCedula(cedula)
                .orElseGet(() -> {
                    User user = userRepository.findById(cedula)
                            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });
    }

    @Transactional
    public Cart addProduct(Long cedula, Long productId, int quantity) {

        Cart cart = getOrCreateCart(cedula);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        cart.getItems().stream()
                .filter(i -> i.getProduct() != null && productId.equals(i.getProduct().getId()))
                .findFirst()
                .ifPresentOrElse(
                        item -> item.setQuantity(item.getQuantity() + quantity),
                        () -> {
                            CartItem newItem = new CartItem();
                            newItem.setCart(cart);
                            newItem.setProduct(product);
                            newItem.setQuantity(quantity);
                            cart.getItems().add(newItem);
                        }
                );

        return cartRepository.save(cart);
    }

    public Cart getCart(Long cedula) {

        return getOrCreateCart(cedula);

    }

    @Transactional
    public Cart removeItem(Long cedula, Long itemId) {
        Cart cart = getOrCreateCart(cedula);
        boolean removed = cart.getItems().removeIf(i -> Objects.equals(i.getId(), itemId));
        if (!removed){
            throw new RuntimeException("El producto no está en el carrito");
        }
        return cartRepository.save(cart);
    }

    public BigDecimal calculateTotal(Long cedula) {
        Cart cart = getOrCreateCart(cedula);
        BigDecimal total = cart.getItems().stream()
                .map(i -> i.getProduct().getPrice()
                        .multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        return total;
    }



}