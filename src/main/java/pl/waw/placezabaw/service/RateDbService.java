package pl.waw.placezabaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.waw.placezabaw.domain.Rate;
import pl.waw.placezabaw.repository.RateDao;

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
    public Rate saveRate(final Rate rate) {
        return rateDao.save(rate);
    }
    public void deleteRate(final Integer id) {
        rateDao.delete(id);
    }
}
