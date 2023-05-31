package com.assignment.product.rest.ShortUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class UrlService {

    @Autowired
    private UserRepository repository;

//    String originalUrl = "https://www.youtube.com/watch?v=2Gik4bFYJbM&t=4540s";

    public String addOriginalUrlAndGenerateShortenedUrl(String originalUrl) {
        UrlTable existingUrl = repository.findByOriginalUrl(originalUrl);
        if (existingUrl != null){
            return existingUrl.getShortenedUrl();
        } else {
            String shortenedUrl = generateShortenedUrl(originalUrl);
            UrlTable urlTable = new UrlTable();
            urlTable.setOriginalUrl(originalUrl);
            urlTable.setShortenedUrl(shortenedUrl);

            if (repository.existsByShortenedUrl(shortenedUrl)){
            }

            repository.save(urlTable);

            return shortenedUrl;
        }
    }

    private String generateShortenedUrl(String originalUrl){
        String extractedChars = removeSpecialCharacters(originalUrl);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        Set<Character> usedChars = new HashSet<>();

        while (sb.length() < 6){
            int index = random.nextInt(extractedChars.length());
            char c = extractedChars.charAt(index);
            if (!usedChars.contains(c)){
                sb.append(c);
                usedChars.add(c);
            }
        }
        return "shortUrl/" + sb.toString();
    }

    private String removeSpecialCharacters(String originalUrl) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<originalUrl.length();i++){
            char c = originalUrl.charAt(i);
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public List<UrlTable> fetchAllFromDB() {
        return repository.findAll();
    }
}
