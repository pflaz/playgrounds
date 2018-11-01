package pl.waw.placezabaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.domain.Rate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface RateDao extends CrudRepository<Rate, Integer> {

    @Override
    List<Rate> findAll();

    Optional<Rate> findById(Integer id);

    @Override
    Rate save(Rate rate);


    List<Rate> findByRate(int rate);
}
