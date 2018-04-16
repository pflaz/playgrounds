package pl.waw.placezabaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.domain.AttractionType;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AttractionTypeDao extends CrudRepository<AttractionType, Integer> {
}
