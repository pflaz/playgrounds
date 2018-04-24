package pl.waw.placezabaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.domain.Playground;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PlaygroundDao extends CrudRepository<Playground, Integer> {
    @Override
    List<Playground> findAll();

    Optional<Playground> findById(Integer id);

    @Override
    Playground save(Playground playground);

    @Override
    void delete(Integer id);
}
