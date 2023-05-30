package com.assignment.product.rest.ShortUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping("/generateShortenedUrl")
    public String generateShortenedUrl(@RequestBody String originalUrl){
        return service.addOriginalUrlAndGenerateShortenedUrl(originalUrl);
    }

}
