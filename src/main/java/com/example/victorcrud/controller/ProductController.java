package com.example.victorcrud.controller;

import com.example.victorcrud.entity.Product;
import com.example.victorcrud.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping
    @Operation(description = "Метод для создания/редактирования карточки товара")
    public Product save(@RequestBody Product product) {
        log.info("REST request to save : {}", product);
        return productService.save(product);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(description = "Метод возвращающий карточку товара по его идентификатору (id)")
    public void delete(@PathVariable Long id) {
        log.info("REST request to delete product with id {}", id);
        productService.delete(id);
    }

    @GetMapping
    @Operation(description = "Метод возвращающий список всех товаров")
    public List<Product> findAll() {
        log.info("REST request to find all products");
        return productService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Product findOne(@PathVariable Long id) {
        return productService.findOne(id);
    }
}
