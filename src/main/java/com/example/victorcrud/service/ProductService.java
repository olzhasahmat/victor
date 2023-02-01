package com.example.victorcrud.service;

import com.example.victorcrud.entity.Product;
import com.example.victorcrud.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findOne(Long id) {
        Optional<Product> optional = productRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException("Product with id " + id + " not found");
        }
    }
}
