package pl.waw.placezabaw.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.waw.placezabaw.domain.Attraction;
import pl.waw.placezabaw.domain.AttractionDto;
import pl.waw.placezabaw.domain.AttractionType;
import pl.waw.placezabaw.domain.Playground;
import pl.waw.placezabaw.exceptions.AttractionTypeNotFoundException;
import pl.waw.placezabaw.exceptions.PlaygroundNotFoundException;
import pl.waw.placezabaw.service.AttractionTypeDbService;
import pl.waw.placezabaw.service.PlaygroundDbService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AttractionMapper {

    private AttractionTypeDbService attractionTypeDbService;
    private PlaygroundDbService playgroundDbService;

    @Autowired
    public AttractionMapper(AttractionTypeDbService attractionTypeDbService, PlaygroundDbService playgroundDbService) {
        this.attractionTypeDbService = attractionTypeDbService;
        this.playgroundDbService = playgroundDbService;
    }

    public Attraction mapToAttraction(final AttractionDto attractionDto) throws AttractionTypeNotFoundException, PlaygroundNotFoundException {

        AttractionType attractionType = attractionTypeDbService.get(attractionDto.getAttractionTypeId()).orElseThrow(AttractionTypeNotFoundException::new);
        Playground playground = playgroundDbService.getPlayground(attractionDto.getPlaygroundId()).orElseThrow(PlaygroundNotFoundException::new);

        return new Attraction(
                attractionDto.getId(),
                attractionType,
                playground,
                attractionDto.getQuantity(),
                attractionDto.getDescription()
                );
    }

    public AttractionDto mapToAttractionDto(final Attraction attraction) {
        return new AttractionDto(
                attraction.getId(),
                attraction.getAttractionType().getId(),
                attraction.getPlayground().getId(),
                attraction.getQuantity(),
                attraction.getDescription()
        );
    }

    public List<AttractionDto> mapToAttractionDtoList(final List<Attraction> attractionList) {
        return attractionList.stream()
                .map(this::mapToAttractionDto)
                .collect(Collectors.toList());
    }
}
