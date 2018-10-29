package pl.waw.placezabaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.placezabaw.domain.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();

    Optional<User> findById(Integer id);

//    @Override
//    User save(User user);

    @Override
    void delete(Integer id);

}
