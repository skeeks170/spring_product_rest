package com.assignment.product.rest.ShortUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;

    public String addOriginalUrlAndGenerateShortenedUrl(String originalUrl) {
        UrlTable existingUrl = repository.findByOriginalUrl(originalUrl);
        if (existingUrl != null) {
            // URL already exists, return the existing shortened URL
            return "the shortened url that has already been generated : " + existingUrl.getShortenedUrl();
        } else {
            String shortenedUrl = generateShortenedUrl(originalUrl);
            UrlTable urlTable = new UrlTable();
            urlTable.setOriginalUrl(originalUrl);
            urlTable.setShortenedUrl(shortenedUrl);

            if (repository.existsByShortenedUrl(shortenedUrl)) {
                return generateShortenedUrl(originalUrl); // Generate a new shortened URL recursively
            }

            repository.save(urlTable);

            return "The shortened Url is : " + shortenedUrl;
        }
    }

    private String generateShortenedUrl(String originalUrl) {
        String extractedChars = removeSpecialCharacters(originalUrl);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        Set<Character> usedChars = new HashSet<>();

        while (sb.length() < 5) {
            int index = random.nextInt(extractedChars.length());
            char c = extractedChars.charAt(index);
            if (!usedChars.contains(c)) {
                sb.append(c);
                usedChars.add(c);
            }
        }

        return "shortUrl/" + sb.toString();
    }

    private String removeSpecialCharacters(String originalUrl) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < originalUrl.length(); i++) {
            char c = originalUrl.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

