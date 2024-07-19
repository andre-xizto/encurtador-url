package dev.buskopan.encurtaa.services;

import dev.buskopan.encurtaa.entities.URL;
import dev.buskopan.encurtaa.exceptions.exception.OriginalUrlNotFound;
import dev.buskopan.encurtaa.interfaces.UrlService;
import dev.buskopan.encurtaa.repositories.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public URL getOriginalUrl(String shortUrl) {
        Optional<URL> url = urlRepository.findByShortUrl(shortUrl);
        if (url.isEmpty()) throw new OriginalUrlNotFound("URL not found");
        return url.get();
    }

    @Override
    public URL createShortUrl(String originalUrl) {

        URL url = new URL();
        url.setOriginalUrl(originalUrl);
        url.setViews(0);
        url.setShortUrl(generateShort());
        url.setExpiryAt(LocalDateTime.now().plusDays(1));
        urlRepository.save(url);

        return url;
    }

    private String generateShort() {
        return RandomStringUtils.randomAlphanumeric(5, 11);
    }
}
