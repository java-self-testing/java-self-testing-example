package cn.prinf.demos.junit.api.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ProductControllerTest {

    @Nested
    @DisplayName("query product list suite")
    class QueryProduct {
        @Test
        void should_list_product_list_with_default_page() {
            //
            System.out.println("should_list_product_list_with_default_page");
        }

        @Test
        void should_list_product_list_with_specify_page() {
            //
            System.out.println("should_list_product_list_with_specify_page");
        }
    }

    @Nested
    @DisplayName("add product test suite")
    class AddProduct {
        @Test
        void should_add_product_success() {
            //
            System.out.println("should_add_product_success");
        }

        @Test
        void should_add_product_failed_when_exceed_product_limitation() {
            //
            System.out.println("should_add_product_failed_when_exceed_product_limitation");
        }
    }
}
