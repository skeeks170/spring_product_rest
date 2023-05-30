package com.assignment.product.rest.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByPlaceContains(String place);
    Product findByName(String name);
    List<Product> findByWarrantyYearLessThan(int warrantyYear);
}
