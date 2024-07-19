package dev.buskopan.encurtaa.repositories;

import dev.buskopan.encurtaa.entities.URL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<URL, Long> {
    Optional<URL> findByShortUrl(String shortUrl);
}
