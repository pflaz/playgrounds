package pl.waw.placezabaw.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.Playground;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface PlaygroundDao extends CrudRepository<Playground, Integer> {
}
