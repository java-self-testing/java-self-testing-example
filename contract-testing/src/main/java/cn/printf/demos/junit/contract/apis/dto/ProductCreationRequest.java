package cn.printf.demos.junit.contract.apis.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductCreationRequest {

    private String name;

    private String description;

    private BigDecimal price;
}
