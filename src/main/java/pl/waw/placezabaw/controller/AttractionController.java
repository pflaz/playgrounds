package pl.waw.placezabaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.waw.placezabaw.domain.AttractionDto;
import pl.waw.placezabaw.exceptions.AttractionNotFoundException;
import pl.waw.placezabaw.exceptions.AttractionTypeNotFoundException;
import pl.waw.placezabaw.exceptions.PlaygroundNotFoundException;
import pl.waw.placezabaw.mapper.AttractionMapper;
import pl.waw.placezabaw.service.AttractionDbService;

import java.util.List;

@RestController
@RequestMapping("/v1/attractions")
public class AttractionController {

    private AttractionDbService attractionDbService;
    private AttractionMapper attractionMapper;

    @Autowired
    public AttractionController(AttractionDbService attractionDbService, AttractionMapper attractionMapper) {
        this.attractionDbService = attractionDbService;
        this.attractionMapper = attractionMapper;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AttractionDto> getAll() {
        return attractionMapper.mapToAttractionDtoList(attractionDbService.getAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AttractionDto get(@PathVariable int id) throws AttractionNotFoundException {
        return attractionMapper.mapToAttractionDto(attractionDbService.get(id).orElseThrow(AttractionNotFoundException::new));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AttractionDto create(@RequestBody AttractionDto attractionDto) throws AttractionTypeNotFoundException, PlaygroundNotFoundException {
        attractionDto.setId(0);
        return attractionMapper.mapToAttractionDto(attractionDbService.save(attractionMapper.mapToAttraction(attractionDto)));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AttractionDto update(@PathVariable int id, @RequestBody AttractionDto attractionDto) throws AttractionTypeNotFoundException, PlaygroundNotFoundException, AttractionNotFoundException {
        return attractionMapper.mapToAttractionDto(attractionDbService.update(id, attractionMapper.mapToAttraction(attractionDto)));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        attractionDbService.delete(id);
    }


}
