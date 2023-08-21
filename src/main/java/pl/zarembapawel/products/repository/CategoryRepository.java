package pl.zarembapawel.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zarembapawel.products.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    CategoryEntity findByName(String name);
}
