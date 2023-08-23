package pl.zarembapawel.products.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.zarembapawel.products.entity.ProductEntity;
import pl.zarembapawel.products.model.Category;
import pl.zarembapawel.products.model.Product;
import pl.zarembapawel.products.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private ProductRepository repository;

    private CategoryService categoryService;

    private ModelMapper mapper;

    public List<Product> getAll() {
        List<ProductEntity> entities = repository.findAll();
        List<Product> products = new ArrayList<>();
        entities.forEach(e -> {
            products.add(mapper.map(e, Product.class));
        });
        return products;
    }

    public Product getProduct(Integer id) {
        Optional<ProductEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapper.map(entity, Product.class);
        }
        return null;
    }

    public HttpStatus add(Product product) {
        log.info("Adding product: {}", product);
        Category category = categoryService.getCategory(product.getCategory());
        if (category == null) {
            log.error("Category don't exist");
            return HttpStatus.BAD_REQUEST;
        }
        product.setDateAdd(LocalDateTime.now());
        product.setDateUpdate(LocalDateTime.now());
        ProductEntity entity = mapper.map(product, ProductEntity.class);
        repository.save(entity);
        log.info("Product has been added");
        return HttpStatus.CREATED;
    }

    public HttpStatus update(Integer id, Product product) {
        log.info("Updating product: {}", product);
        Optional<ProductEntity> optEntity = repository.findById(id);
        if (optEntity.isEmpty()) {
            log.error("Product don't exist");
            return HttpStatus.BAD_REQUEST;
        }
        ProductEntity entity = optEntity.get();
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setDateUpdate(LocalDateTime.now());
        repository.save(entity);
        log.info("Product has been updated");
        return HttpStatus.NO_CONTENT;
    }

    public HttpStatus delete(Integer id) {
        log.info("Deleting product id: {}", id);
        Optional<ProductEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            log.error("Product don't exist");
            return HttpStatus.BAD_REQUEST;
        }
        repository.delete(entity.get());
        log.info("Product has been deleted");
        return HttpStatus.NO_CONTENT;
    }
}
