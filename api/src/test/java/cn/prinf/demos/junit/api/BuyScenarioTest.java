package cn.prinf.demos.junit.api;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BuyScenarioTest {
    @BeforeAll
    static void beforeAll() {
        // 这里进行通用的准备
    }

    @AfterAll
    static void afterAll() {
        // 这里进行通用的清理
    }

    @Test
    @Order(1)
    void should_list_products() {
        System.out.println("should_list_products");
    }

    @Test
    @Order(2)
    void should_get_product_detail() {
        System.out.println("should_get_product_detail");
    }

    @Test
    @Order(3)
    void should_add_product_to_shopping_cart() {
        System.out.println("should_add_product_to_shopping_cart");
    }
}
