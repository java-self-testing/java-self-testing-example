package cn.printf.demos.junit.contract.apis;

import cn.printf.demos.junit.contract.apis.assembler.ProductAssembler;
import cn.printf.demos.junit.contract.apis.dto.ProductCreationRequest;
import cn.printf.demos.junit.contract.apis.dto.ProductResponse;
import cn.printf.demos.junit.contract.application.ProductService;
import cn.printf.demos.junit.contract.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    private ProductAssembler productAssembler;

    @Autowired
    public ProductController(ProductService productService, ProductAssembler productAssembler) {
        this.productService = productService;
        this.productAssembler = productAssembler;
    }

    @GetMapping(produces = "application/json")
    public List<ProductResponse> getAllProducts() {
        final List<Product> products = productService.getProducts();
        return productAssembler.toProductResponseList(products);
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = "application/json")
    public ProductResponse getProductById(@PathVariable("productId") final Long productId) {

        final Product product = productService.getProductsById(productId);
        return productAssembler.toProductResponse(product);
    }


    @PostMapping(produces = "application/json", consumes = "application/json")
    public ProductResponse createProduct(@RequestBody ProductCreationRequest productCreationRequest) {
        Product product = productAssembler.toDomainObject(productCreationRequest);
        return productAssembler.toProductResponse(productService.save(product));
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable("productId") final Long productId,
                              @RequestBody ProductCreationRequest productUpdateRequest){
        Product newProduct = productAssembler.toDomainObject(productUpdateRequest);
        Product oldProduct = productService.getProductsById(productId);
        if(newProduct.getName() != null){
            oldProduct.setName(newProduct.getName());
        }
        if(newProduct.getDescription() != null){
            oldProduct.setDescription(newProduct.getDescription());

        }
        if (newProduct.getPrice() != null) {
            oldProduct.setPrice(newProduct.getPrice());
        }
        productService.save(oldProduct);
    }
}
