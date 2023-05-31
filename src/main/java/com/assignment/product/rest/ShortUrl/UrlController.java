package com.assignment.product.rest.ShortUrl;

import com.assignment.product.rest.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/urlShort")
@CrossOrigin(origins = "http://localhost:4200")
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping("/generateShortenedUrl")
    public String generateShortenedUrl(@RequestBody String originalUrl){
        return service.addOriginalUrlAndGenerateShortenedUrl(originalUrl);
    }

    @GetMapping("/urlList")
    public List<UrlTable> fetchAllProductsFromDB(){
        return service.fetchAllFromDB();
    }

}
