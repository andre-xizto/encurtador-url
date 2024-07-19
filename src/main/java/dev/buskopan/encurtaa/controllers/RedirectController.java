package dev.buskopan.encurtaa.controllers;

import dev.buskopan.encurtaa.entities.URL;
import dev.buskopan.encurtaa.exceptions.exception.ExpiredUrlException;
import dev.buskopan.encurtaa.exceptions.exception.OriginalUrlNotFound;
import dev.buskopan.encurtaa.services.RedirectServiceImpl;
import dev.buskopan.encurtaa.services.UrlServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;

@RequestMapping("/")
@RestController
public class RedirectController {
    private final UrlServiceImpl urlService;
    private final RedirectServiceImpl redirectService;

    public RedirectController(UrlServiceImpl urlService, RedirectServiceImpl redirectService) {
        this.urlService = urlService;
        this.redirectService = redirectService;
    }

    @GetMapping
    @RequestMapping("{shortUrl}")
    public ResponseEntity<Void> redirect (@PathVariable("shortUrl") String shortUrl) {
        URL originalUrl = urlService.getOriginalUrl(shortUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        boolean isExpired = originalUrl.getExpiryAt().isBefore(LocalDateTime.now());
        if (isExpired) {
            throw new ExpiredUrlException();
        }

        boolean valid = redirectService.isValidUrl(originalUrl.getOriginalUrl());
        if (valid) {
            return ResponseEntity
                    .status(HttpStatus.PERMANENT_REDIRECT)
                    .headers(headers)
                    .header("Location", originalUrl.getOriginalUrl())
                    .build();
        }

        throw new OriginalUrlNotFound("Couldn't reach out to informed URL");
    }

}
