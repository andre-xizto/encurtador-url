package dev.buskopan.encurtaa.interfaces;

import dev.buskopan.encurtaa.entities.URL;


public interface UrlService {

    URL getOriginalUrl(String shortUrl);
    URL createShortUrl(String originalUrl);
}
