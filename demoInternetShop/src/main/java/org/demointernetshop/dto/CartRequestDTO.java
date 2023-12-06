package org.demointernetshop.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CartRequestDTO {
    private List<CartItemDto> cartItems;

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }
}
