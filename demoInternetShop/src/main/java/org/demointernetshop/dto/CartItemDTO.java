package org.demointernetshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(name = "CartItem", description = "Item in the cart")
public class CartItemDto {

    @Schema(description = "Product identifier", example = "1")
    private Integer productId;

    @Schema(description = "Product name", example = "iPhone 15")
    private String productName;

    @Schema(description = "Quantity", example = "2")
    private Integer quantity;

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

