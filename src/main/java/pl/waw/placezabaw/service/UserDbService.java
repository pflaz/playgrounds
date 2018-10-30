package pl.waw.placezabaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.waw.placezabaw.domain.User;
import pl.waw.placezabaw.exceptions.UserNotFoundException;
import pl.waw.placezabaw.repository.UserDao;

import java.util.List;
import java.util.Optional;

@Service
public class UserDbService {

    private UserDao userDao;

    @Autowired
    public UserDbService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
        return userDao.findAll();
    }
    public Optional<User> get(final Integer id) {
        return userDao.findById(id);
    }
    public List<User> findByLogin(String login) {
        return userDao.findByLogin(login);
    }
    public List<User> findByName(String name) {
        return userDao.findByNameContains(name);
    }
    public List<User> findByEmail(String email) {
        return userDao.findByEmailContains(email);
    }
    public List<User> findByLoginAndName(String login, String name) {
        return userDao.findByLoginAndNameContains(login, name);
    }
    public List<User> findByLoginAndEmail(String login, String email) {
        return userDao.findByLoginAndEmailContains(login, email);
    }
    public List<User> findByNameAndEmail(String name, String email) {
        return userDao.findByNameContainsAndEmailContains(name, email);
    }
    public List<User> findByLoginAndNameAndEmail(String login, String name, String email) {
        return userDao.findByLoginAndNameContainsAndEmailContains(login, name, email);
    }

    public User save(final User user) {
        return userDao.save(user);
    }
    public void delete(final Integer id) {
        userDao.delete(id);
    }

    public User update(int userId, User user) throws UserNotFoundException {
        User readUser = userDao.findOne(userId);
        if (readUser == null) {
            throw new UserNotFoundException("User (ID: " + userId + ") not found.");
        }
        readUser.setName(user.getName());
        readUser.setLogin(user.getLogin());
        readUser.setPassword(user.getPassword());
        readUser.setEmail(user.getEmail());

        User result = userDao.save(readUser);
        return result;
    }
}
