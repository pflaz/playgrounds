package pl.waw.placezabaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.waw.placezabaw.domain.User;
import pl.waw.placezabaw.repository.UserDao;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public Optional<User> getUser(final Integer id) {
        return userDao.findById(id);
    }

    public User saveUser(final User user) {
        return userDao.save(user);
    }

    public void deleteUser(final Integer id) {
        userDao.delete(id);
    }
}
