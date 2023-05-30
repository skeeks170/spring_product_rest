package com.assignment.product.rest.ShortUrl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlTable,Integer> {
    UrlTable findByOriginalUrl(String originalUrl);

    boolean existsByShortenedUrl(String shortenedUrl);
}
