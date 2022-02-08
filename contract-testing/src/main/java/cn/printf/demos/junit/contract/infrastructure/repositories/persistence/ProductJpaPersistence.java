package cn.printf.demos.junit.contract.infrastructure.repositories.persistence;

import cn.printf.demos.junit.contract.infrastructure.repositories.dataentity.ProductDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaPersistence extends CrudRepository<ProductDataEntity, Long> {

}
