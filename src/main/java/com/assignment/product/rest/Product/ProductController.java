package com.assignment.product.rest.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/productList")
    public List<Product> fetchAllProductsFromDB(){
        return service.fetchAllFromDB();
    }

    @PostMapping("/addProduct")
    public Product addProductToDB(@RequestBody Product sendProduct){
        return service.addToDB(sendProduct);
    }

    @GetMapping("/deleteProductById/{productId}")
    public void deleteProductInDB(@PathVariable int productId){
        service.deleteFromDB(productId);
    }

    @GetMapping("/productOutOfWarranty")
    public List<Product> fetchProductOutOfWarranty(){
        return service.fetchOutOfWarranty();
    }

    @GetMapping("/productByName/{name}")
    public Product fetchProductByName(@PathVariable String name){
        return service.fetchByName(name);
    }

    @GetMapping("/productByPlace/{place}")
    public List<Product> fetchProductByPlace(@PathVariable String place){
        return service.fetchByPlace(place);
    }

}
