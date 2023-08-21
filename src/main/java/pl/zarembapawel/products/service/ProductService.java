package pl.zarembapawel.products.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.zarembapawel.products.model.Product;
import pl.zarembapawel.products.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private ProductRepository repository;

    private ModelMapper mapper;

    public List<Product> getAll() {
        return null;
    }

    public Product getProduct(Integer id) {
        return null;
    }

    public HttpStatus add(Product product) {
        return null;
    }

    public HttpStatus update(Integer id, Product product) {
        return null;
    }

    public HttpStatus delete(Integer id) {
        return null;
    }
}
