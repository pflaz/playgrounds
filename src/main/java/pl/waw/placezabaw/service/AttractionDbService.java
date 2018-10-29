package pl.waw.placezabaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.waw.placezabaw.domain.Attraction;
import pl.waw.placezabaw.repository.AttractionDao;

import java.util.List;
import java.util.Optional;

@Service
public class AttractionDbService {

    private AttractionDao attractionDao;

    @Autowired
    public AttractionDbService(AttractionDao attractionDao) {
        this.attractionDao = attractionDao;
    }

    public List<Attraction> getAllAttractions() {
        return attractionDao.findAll();
    }
    public Optional<Attraction> getAttraction(final Integer id) {
        return attractionDao.findById(id);
    }
    public Attraction saveAttraction(final Attraction attraction) {
        return attractionDao.save(attraction);
    }
    public void deleteAttraction(final Integer id) {
        attractionDao.delete(id);
    }
}
