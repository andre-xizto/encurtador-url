package dev.buskopan.encurtaa.controllers;

import dev.buskopan.encurtaa.dtos.UrlDTO;
import dev.buskopan.encurtaa.dtos.UrlResponseDTO;
import dev.buskopan.encurtaa.entities.URL;
import dev.buskopan.encurtaa.mapper.UrlMapper;
import dev.buskopan.encurtaa.services.UrlServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlServiceImpl urlService;
    private final UrlMapper urlMapper;

    public UrlController(UrlServiceImpl urlService, UrlMapper urlMapper) {
        this.urlService = urlService;
        this.urlMapper = urlMapper;
    }

    @PostMapping
    public ResponseEntity<UrlResponseDTO> createUrl(@RequestBody UrlDTO dto) {
        URL url = urlService.createShortUrl(dto.url());
        UrlResponseDTO urlDto = urlMapper.toResponseDto(url);
        return ResponseEntity.status(200).body(urlDto);
    }

}
