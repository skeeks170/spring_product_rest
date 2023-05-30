package com.assignment.product.rest.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> fetchAllFromDB() {
        return repository.findAll();
    }

    public Product addToDB(Product sendProduct) {
        return repository.save(sendProduct);
    }


    public List<Product> fetchOutOfWarranty() {
        return repository.findByWarrantyYearLessThan(2023);
    }

    public Product fetchByName(String name) {
        return repository.findByName(name);
    }

    public List<Product> fetchByPlace(String place) {
        return repository.findByPlaceContains(place);
    }

    public void deleteFromDB(int productId) {
        repository.deleteById(productId);
    }
}
