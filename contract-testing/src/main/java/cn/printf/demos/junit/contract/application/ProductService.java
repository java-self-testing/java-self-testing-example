package cn.printf.demos.junit.contract.application;

import cn.printf.demos.junit.contract.product.Product;
import cn.printf.demos.junit.contract.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductsById(Long productId) {
        return repository.findById(productId);
    }

    public Product save(Product product) {
        return repository.findById(repository.save(product));
    }
}
