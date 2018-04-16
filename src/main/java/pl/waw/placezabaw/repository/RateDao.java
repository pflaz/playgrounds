package pl.waw.placezabaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.domain.Rate;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RateDao extends CrudRepository<Rate, Integer> {
}
