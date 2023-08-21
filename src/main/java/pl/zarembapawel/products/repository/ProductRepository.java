package pl.zarembapawel.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zarembapawel.products.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}