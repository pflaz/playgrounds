package pl.waw.placezabaw.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.waw.placezabaw.domain.Attraction;
import pl.waw.placezabaw.domain.AttractionType;
import pl.waw.placezabaw.domain.AttractionTypeDto;
import pl.waw.placezabaw.exceptions.AttractionTypeNotFoundException;
import pl.waw.placezabaw.mapper.AttractionTypeMapper;
import pl.waw.placezabaw.service.AttractionTypeDbService;

import java.util.List;

@RestController
@RequestMapping("v1/attractionTypes")
public class AttractionTypeController {

    private AttractionTypeDbService dbService;
    private AttractionTypeMapper mapper;

    @Autowired
    public AttractionTypeController(AttractionTypeDbService dbService, AttractionTypeMapper attractionTypeMapper) {
        this.dbService = dbService;
        this.mapper = attractionTypeMapper;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<AttractionTypeDto> getAll() {
        return  mapper.mapToAttractionTypeDtoList(dbService.getAll());
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public AttractionTypeDto get(@PathVariable int id) throws AttractionTypeNotFoundException {
        return mapper.mapToAttractionTypeDto(dbService.get(id).orElseThrow(AttractionTypeNotFoundException::new));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public AttractionTypeDto create(@RequestBody AttractionTypeDto attractionTypeDto) {
        attractionTypeDto.setId(0);
        return mapper.mapToAttractionTypeDto(dbService.save(mapper.mapToAttractionType(attractionTypeDto)));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AttractionTypeDto update(@PathVariable int id, @RequestBody AttractionTypeDto attractionTypeDto) throws AttractionTypeNotFoundException {
        return mapper.mapToAttractionTypeDto(dbService.update(id, mapper.mapToAttractionType(attractionTypeDto)));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        dbService.delete(id);
    }

}
