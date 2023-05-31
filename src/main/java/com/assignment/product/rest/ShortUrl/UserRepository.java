package com.assignment.product.rest.ShortUrl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UrlTable,Integer> {

    boolean existsByShortenedUrl(String shortenedUrl);
    UrlTable findByOriginalUrl(String originalUrl);
}
