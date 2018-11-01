package pl.waw.placezabaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.domain.AttractionType;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface AttractionTypeDao extends CrudRepository<AttractionType, Integer> {

    @Override
    List<AttractionType> findAll();

    Optional<AttractionType> findById(Integer id);

    List<AttractionType> findByNameContains(String name);

    @Override
    AttractionType save(AttractionType attractionType);

}
