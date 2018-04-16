package pl.waw.placezabaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.domain.Playground;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface PlaygroundDao extends CrudRepository<Playground, Integer> {
}
