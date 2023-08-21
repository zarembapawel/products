package pl.zarembapawel.products.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.zarembapawel.products.model.Product;
import pl.zarembapawel.products.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products/products")
@AllArgsConstructor
public class ProductsController {

    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Integer productId) {
        Product product = service.getProduct(productId);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return product;
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Product product) {
        HttpStatus status = service.add(product);
        return new ResponseEntity<>(status);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> update(@PathVariable Integer productId, @RequestBody Product product) {
        HttpStatus status = service.update(productId, product);
        return new ResponseEntity<>(status);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable Integer productId) {
        HttpStatus status = service.delete(productId);
        return new ResponseEntity<>(status);
    }
}
