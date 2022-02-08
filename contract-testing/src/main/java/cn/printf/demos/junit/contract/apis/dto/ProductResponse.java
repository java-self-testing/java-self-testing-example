package cn.printf.demos.junit.contract.apis.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
