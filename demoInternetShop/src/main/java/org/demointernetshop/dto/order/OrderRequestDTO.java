package org.demointernetshop.dto.order;

import lombok.Getter;
import org.demointernetshop.dto.CartDto;
import org.demointernetshop.dto.CartItemDto;

import java.util.List;

@Getter
public class OrderRequestDTO {
    private List<CartItemDto> cartItems;
    private Long userId;

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

