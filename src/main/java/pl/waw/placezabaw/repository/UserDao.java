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

    List<User> findByLogin(String login);
    List<User> findByNameContains(String name);
    List<User> findByEmailContains(String email);
    List<User> findByLoginAndNameContains(String login, String name);
    List<User> findByLoginAndEmailContains(String login, String email);
    List<User> findByNameContainsAndEmailContains(String name, String email);
    List<User> findByLoginAndNameContainsAndEmailContains(String login, String name, String email);

    Optional<User> findById(Integer id);

//    @Override
//    User save(User user);

/*    @Override
    void delete(Integer id);*/

}
