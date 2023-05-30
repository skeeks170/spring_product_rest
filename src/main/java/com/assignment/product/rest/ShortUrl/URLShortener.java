package com.assignment.product.rest.ShortUrl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class URLShortener {
    public static void main(String[] args) {
        String originalUrl = "https://www.youtube.com/watch?v=2Gik4bFYJbM&t=4540s";
        String shortenedUrl = generateShortenedUrl(originalUrl, 5);

        System.out.println("Shortened URL: " + shortenedUrl);
    }

    public static String generateShortenedUrl(String originalUrl, int length) {
        String extractedChars = removeSpecialCharacters(originalUrl);

        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        Set<Character> usedChars = new HashSet<>();

        while (sb.length() < length) {
            int index = random.nextInt(extractedChars.length());
            char c = extractedChars.charAt(index);
            if (!usedChars.contains(c)) {
                sb.append(c);
                usedChars.add(c);
            }
        }

        return "shortUrl/" + sb.toString();
    }

    public static String removeSpecialCharacters(String originalUrl) {
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
