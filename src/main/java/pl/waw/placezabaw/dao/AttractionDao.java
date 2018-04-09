package pl.waw.placezabaw.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.Attraction;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AttractionDao extends CrudRepository<Attraction, Integer> {
}
