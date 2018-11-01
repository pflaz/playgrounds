package pl.waw.placezabaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.waw.placezabaw.domain.Rate;
import pl.waw.placezabaw.exceptions.RateNotFoundException;
import pl.waw.placezabaw.repository.RateDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RateDbService {

    private RateDao rateDao;

    @Autowired
    public RateDbService(RateDao rateDao) {
        this.rateDao = rateDao;
    }

    public List<Rate> getAllRates() {
        return rateDao.findAll();
    }
    public Optional<Rate> getRate(final Integer id) {
        return rateDao.findById(id);
    }

    public List<Rate> findByRate(int rate) {
        return rateDao.findByRate(rate);
    }

    public Rate saveRate(Rate rate) {
        if (rate.getRatedDateTime() == null) {
            rate.setRatedDateTime(LocalDateTime.now());
        }
        return rateDao.save(rate);
    }

    public Rate update(int id, Rate rate) throws RateNotFoundException {
        Rate readRate = rateDao.findById(id).orElse(null);
        if (readRate == null) {
            throw new RateNotFoundException("Rate ID: " + id + " not found.");
        }
        rate.setId(id);
        return rateDao.save(rate);
    }
    public void deleteRate(final Integer id) {
        rateDao.deleteById(id);
    }
}
