
package cn.printf.demos.junit.contract.product;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {

    private Long id;

    private String name;

    private String description;

    private ProductPrice price;

    private Boolean isOnSale;

    public Product(Long id, String name, String description, ProductPrice price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}

