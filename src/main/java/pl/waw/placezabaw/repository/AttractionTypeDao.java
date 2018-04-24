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

    @Override
    AttractionType save(AttractionType attractionType);

    @Override
    void delete(Integer id);
}
