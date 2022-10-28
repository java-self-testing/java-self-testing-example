package cn.prinf.demos.junit.api.strategy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BuyScenarioTest {
    @Test
    void buy_scenario_test() {
        // 这里进行通用的准备
        shouldListProducts();
        shouldGetProductDetail();
        shouldAddProductToShoppingCart();
        // 这里进行通用的清理
    }

    void shouldListProducts() {
        System.out.println("should_list_products");
    }

    void shouldGetProductDetail() {
        System.out.println("should_get_product_detail");
    }

    void shouldAddProductToShoppingCart() {
        System.out.println("should_add_product_to_shopping_cart");
    }
}
