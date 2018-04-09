package pl.waw.placezabaw.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.AttractionType;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AttractionTypeDao extends CrudRepository<AttractionType, Integer> {
}
