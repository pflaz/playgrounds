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
    public User save(final User user) {
        return userDao.save(user);
    }
    public void delete(final Integer id) {
        userDao.delete(id);
    }

    public User update(int userId, User user) throws UserNotFoundException {
        User tmpUser = userDao.findOne(userId);
        if (tmpUser == null) {
            throw new UserNotFoundException("User (ID: " + userId + ") not found.");
        }
        user.setId(userId);
        return userDao.save(user);
    }
}
