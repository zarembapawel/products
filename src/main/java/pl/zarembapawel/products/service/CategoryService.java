package pl.zarembapawel.products.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.zarembapawel.products.entity.CategoryEntity;
import pl.zarembapawel.products.model.Category;
import pl.zarembapawel.products.repository.CategoryRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryService {

    private CategoryRepository repository;

    private ModelMapper mapper;

    public HttpStatus add(Category category) {
        log.info("Adding category: {}", category);
        CategoryEntity current = repository.findByName(category.getName());
        if (current != null) {
            log.error("Category already exist");
            return HttpStatus.CONFLICT;
        }
        category.setDateAdd(LocalDateTime.now());
        category.setDateUpdate(LocalDateTime.now());
        CategoryEntity entity = mapper.map(category, CategoryEntity.class);
        repository.save(entity);
        log.info("Category has been added");
        return HttpStatus.CREATED;
    }
}
