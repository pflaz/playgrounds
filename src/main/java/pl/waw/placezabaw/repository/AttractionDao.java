package pl.waw.placezabaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.domain.Attraction;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface AttractionDao extends CrudRepository<Attraction, Integer> {
    @Override
    List<Attraction> findAll();

    Optional<Attraction> findById(Integer id);

    List<Attraction> findByAttractionTypeId(int attractionTypeId);
    List<Attraction> findByPlaygroundId(int playgroundId);
    List<Attraction> findByAttractionTypeIdAndPlaygroundId(int attractionTypeId, int playgroundId);

    @Override
    Attraction save(Attraction attraction);

}
