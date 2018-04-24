package pl.waw.placezabaw.mapper;

import org.springframework.stereotype.Component;
import pl.waw.placezabaw.domain.AttractionType;
import pl.waw.placezabaw.domain.AttractionTypeDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AttractionTypeMapper {
    public AttractionType mapToAttractionType(final AttractionTypeDto attractionTypeDto) {
        return new AttractionType(
                attractionTypeDto.getId(),
                attractionTypeDto.getName()
        );
    }

    public AttractionTypeDto mapToAttractionTypeDto(final AttractionType attractionType) {
        return new AttractionTypeDto(
          attractionType.getId(),
          attractionType.getName()
        );
    }

    public List<AttractionTypeDto> mapToAttractionTypeDtoList(final List<AttractionType> attractionTypeList) {
        return attractionTypeList.stream()
                .map(attractionType -> new AttractionTypeDto(attractionType.getId(), attractionType.getName()))
                .collect(Collectors.toList());
    }
}
