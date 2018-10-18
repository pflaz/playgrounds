package pl.waw.placezabaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.waw.placezabaw.domain.*;
import pl.waw.placezabaw.exceptions.UserNotFoundException;
import pl.waw.placezabaw.repository.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    UserDao userDao;
    AttractionTypeDao attractionTypeDao;
    AttractionDao attractionDao;
    PlaygroundDao playgroundDao;
    RateDao rateDao;

    @Autowired
    public DbService(UserDao userDao, AttractionTypeDao attractionTypeDao, AttractionDao attractionDao, PlaygroundDao playgroundDao, RateDao rateDao) {
        this.userDao = userDao;
        this.attractionTypeDao = attractionTypeDao;
        this.attractionDao = attractionDao;
        this.playgroundDao = playgroundDao;
        this.rateDao = rateDao;
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }
    public Optional<User> getUser(final Integer id) {
        return userDao.findById(id);
    }
    public User saveUser(final User user) {
        return userDao.save(user);
    }
    public void deleteUser(final Integer id) {
        userDao.delete(id);
    }

    public User updateUser(int userId, User user) throws UserNotFoundException {
        User tmpUser = userDao.findOne(userId);
        if (tmpUser == null) {
            throw new UserNotFoundException("User (ID: " + userId + ") not found.");
        }
        user.setId(userId);
        return userDao.save(user);
    }

    public List<AttractionType> getAllAttractionTypes() {
        return attractionTypeDao.findAll();
    }
    public Optional<AttractionType> getAttractionType(final Integer id) {
        return attractionTypeDao.findById(id);
    }
    public AttractionType saveAttractionType(final AttractionType attractionType) {
        return attractionTypeDao.save(attractionType);
    }
    public void deleteAttractionType(final Integer id) {
        attractionTypeDao.delete(id);
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

    public List<Playground> getAllPlaygrounds() {
        return playgroundDao.findAll();
    }
    public Optional<Playground> getPlayground(final Integer id) {
        return playgroundDao.findById(id);
    }
    public Playground savePlayground(final Playground playground) {
        return playgroundDao.save(playground);
    }
    public void deletePlayground(final Integer id) {
        playgroundDao.delete(id);
    }

    public List<Rate> getAllRates() {
        return rateDao.findAll();
    }
    public Optional<Rate> getRate(final Integer id) {
        return rateDao.findById(id);
    }
    public Rate saveRate(final Rate rate) {
        return rateDao.save(rate);
    }
    public void deleteRate(final Integer id) {
        rateDao.delete(id);
    }


}
