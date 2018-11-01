package pl.waw.placezabaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.waw.placezabaw.domain.Attraction;
import pl.waw.placezabaw.exceptions.AttractionNotFoundException;
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

    public List<Attraction> getAll() {
        return attractionDao.findAll();
    }
    public Optional<Attraction> get(final Integer id) {
        return attractionDao.findById(id);
    }

    public List<Attraction> findByAttractionTypeId(final int attractionTypeId) {
        return attractionDao.findByAttractionTypeId(attractionTypeId);
    }

    public List<Attraction> findByPlaygroundId(final int playgroundId) {
        return attractionDao.findByPlaygroundId(playgroundId);
    }

    public List<Attraction> findByAttractionTypeIdAndPlaygroundId(final int attractionTypeId, final int playgroundId) {
        return attractionDao.findByAttractionTypeIdAndPlaygroundId(attractionTypeId, playgroundId);
    }

    public Attraction update(final int id, Attraction attraction) throws AttractionNotFoundException {
        Attraction readAttraction = attractionDao.findById(id).orElse(null);
        if (readAttraction == null) {
            throw new AttractionNotFoundException("Attraction ID: " + id + " not found.");
        }
        attraction.setId(id);
        attractionDao.save(attraction);
        return attraction;
    }

    public Attraction save(final Attraction attraction) {
        return attractionDao.save(attraction);
    }
    public void delete(final Integer id) {
        attractionDao.deleteById(id);
    }
}
