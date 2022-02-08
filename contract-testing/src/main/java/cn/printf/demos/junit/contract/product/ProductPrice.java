
package cn.printf.demos.junit.contract.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@Setter
public class ProductPrice {

    private String currency;

    private BigDecimal value;

    static public ProductPrice of(String currency, BigDecimal value) {
        return new ProductPrice(currency, value);
    }
}

