package pl.waw.placezabaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.domain.Attraction;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AttractionDao extends CrudRepository<Attraction, Integer> {
}
