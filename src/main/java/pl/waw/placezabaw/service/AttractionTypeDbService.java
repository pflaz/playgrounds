package pl.waw.placezabaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.waw.placezabaw.domain.AttractionType;
import pl.waw.placezabaw.repository.AttractionTypeDao;

import java.util.List;
import java.util.Optional;

@Service
public class AttractionTypeDbService {

    private AttractionTypeDao attractionTypeDao;

    @Autowired
    public AttractionTypeDbService(AttractionTypeDao attractionTypeDao) {
        this.attractionTypeDao = attractionTypeDao;
    }

    public List<AttractionType> getAll() {
        return attractionTypeDao.findAll();
    }
    public Optional<AttractionType> get(final Integer id) {
        return attractionTypeDao.findById(id);
    }
    public AttractionType save(final AttractionType attractionType) {
        return attractionTypeDao.save(attractionType);
    }
    public void delete(final Integer id) {
        attractionTypeDao.delete(id);
    }
}
