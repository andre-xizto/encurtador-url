package dev.buskopan.encurtaa.mapper;

import dev.buskopan.encurtaa.dtos.UrlDTO;
import dev.buskopan.encurtaa.dtos.UrlResponseDTO;
import dev.buskopan.encurtaa.entities.URL;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class UrlMapper {

    private final ModelMapper modelMapper;

    public UrlMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        configureMappings();
    }

    private void configureMappings() {
        TypeMap<URL, UrlResponseDTO> typeMap = modelMapper.createTypeMap(URL.class, UrlResponseDTO.class);
        typeMap.setProvider(request -> {
           URL source = (URL) request.getSource();
           return new UrlResponseDTO(source.getShortUrl());
        });
    }

    public UrlResponseDTO toResponseDto(URL url) {
        return modelMapper.map(url, UrlResponseDTO.class);
    }
}
