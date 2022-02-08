package cn.printf.demos.junit.contract.application;

import cn.printf.demos.junit.contract.product.Product;
import cn.printf.demos.junit.contract.product.ProductPrice;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductFactory {

    protected static final ModelMapper mapper = new ModelMapper();

    public Product create(String name, String description, BigDecimal price, Boolean isOnSale) {
        return Product.builder()
                .name(name)
                .description(description)
                .price(ProductPrice.of("RMB", price))
                .isOnSale(isOnSale)
                .build();
    }
}
