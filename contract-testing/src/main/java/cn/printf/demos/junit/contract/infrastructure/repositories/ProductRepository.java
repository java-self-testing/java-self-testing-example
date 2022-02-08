package cn.printf.demos.junit.contract.infrastructure.repositories;

import cn.printf.demos.junit.contract.product.Product;
import cn.printf.demos.junit.contract.infrastructure.repositories.dataentity.ProductDataEntity;
import cn.printf.demos.junit.contract.infrastructure.repositories.persistence.ProductJpaPersistence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {

    protected static final ModelMapper mapper = new ModelMapper();

    @Autowired
    private ProductJpaPersistence repository;

    public Long save(Product product) {
        ProductDataEntity productDataEntity  =
                repository.save(mapper.map(product, ProductDataEntity.class));
        return  productDataEntity.getId();
    }


    public Product findById(Long productId) {
        Optional<ProductDataEntity> product = repository.findById(productId);
        return product.map(productDataEntity -> mapper.map(productDataEntity, Product.class)).orElse(null);
    }

    public List<Product> findAll() {
        List<Product> result = new ArrayList<>();

        Iterable<ProductDataEntity> iterable = repository.findAll();

        iterable.forEach((productDataEntity) -> result.add(mapper.map(productDataEntity, Product.class)));

        return result;
    }
}
