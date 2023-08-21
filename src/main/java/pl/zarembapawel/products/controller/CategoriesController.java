package pl.zarembapawel.products.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zarembapawel.products.model.Category;
import pl.zarembapawel.products.service.CategoryService;

@RestController
@RequestMapping("/products/categories")
@AllArgsConstructor
public class CategoriesController {

    private CategoryService service;

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Category category) {
        HttpStatus status = service.add(category);
        return new ResponseEntity<>(status);
    }
}
