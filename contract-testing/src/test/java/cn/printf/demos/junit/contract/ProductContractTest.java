package cn.printf.demos.junit.contract;


import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import cn.printf.demos.junit.contract.apis.ProductController;
import cn.printf.demos.junit.contract.apis.assembler.ProductAssembler;
import cn.printf.demos.junit.contract.application.ProductService;
import cn.printf.demos.junit.contract.product.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Arrays;

@RunWith(RestPactRunner.class)
@PactFolder("contracts")
@Provider("product-service")
public class ProductContractTest {

    @Mock
    private ProductService productService;

    @Spy
    private ProductAssembler productAssembler;

    @InjectMocks
    private ProductController productController;

    @TestTarget
    public final MockMvcTarget target = new MockMvcTarget();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        target.setControllers(productController);
        target.setPrintRequestResponse(true);
    }

    @Test
    @State("Get all products")
    public ProductController should_get_all_products() {
        Mockito.when(productService.getProducts()).thenReturn(Arrays.asList(
                new Product() {{
                    setId(1L);
                    setName("Book");
                    setPrice(null);
                    setIsOnSale(true);
                    setDescription("Some Books");
                }}
        ));
        return productController;
    }
}
