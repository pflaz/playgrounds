package pl.waw.placezabaw.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.Rate;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RateDao extends CrudRepository<Rate, Integer> {
}
