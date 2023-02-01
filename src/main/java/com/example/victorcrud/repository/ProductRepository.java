package com.example.victorcrud.repository;

import com.example.victorcrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
