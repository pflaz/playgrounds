package pl.waw.placezabaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.waw.placezabaw.domain.RateDto;
import pl.waw.placezabaw.exceptions.PlaygroundNotFoundException;
import pl.waw.placezabaw.exceptions.RateNotFoundException;
import pl.waw.placezabaw.exceptions.UserNotFoundException;
import pl.waw.placezabaw.mapper.RateMapper;
import pl.waw.placezabaw.service.RateDbService;

import java.util.List;

@RestController
@RequestMapping("/v1/rates")
public class RateController {

    private RateDbService rateDbService;
    private RateMapper rateMapper;

    @Autowired
    public RateController(RateDbService rateDbService, RateMapper rateMapper) {
        this.rateDbService = rateDbService;
        this.rateMapper = rateMapper;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RateDto> getAll() {
        return rateMapper.mapToRateDtoList(rateDbService.getAllRates());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RateDto get(@PathVariable int id) throws RateNotFoundException {
        return rateMapper.mapToRateDto(rateDbService.getRate(id).orElseThrow(RateNotFoundException::new));
    }

    /**
     * Finds 'Rate' records with specified 'rate' field
     * @param rate rate to find
     * @return list of 'Rate' records with specified 'rate' field
     */
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RateDto> search(@RequestParam int rate) {
        return rateMapper.mapToRateDtoList(rateDbService.findByRate(rate));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RateDto create(@RequestBody RateDto rateDto) throws UserNotFoundException, PlaygroundNotFoundException {
        return rateMapper.mapToRateDto(rateDbService.saveRate(rateMapper.mapToRate(rateDto)));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RateDto update(@PathVariable int id, @RequestBody RateDto rateDto) throws UserNotFoundException, PlaygroundNotFoundException, RateNotFoundException {
        return rateMapper.mapToRateDto(rateDbService.update(id, rateMapper.mapToRate(rateDto)));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        rateDbService.deleteRate(id);
    }

}
