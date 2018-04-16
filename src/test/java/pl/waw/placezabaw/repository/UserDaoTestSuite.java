package pl.waw.placezabaw.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.waw.placezabaw.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTestSuite {
    @Autowired
    UserDao userDao;

    @Test
    public void testSaveUser() {
        // Given
        User user = new User("username", "user login", "pass", "e@mail");

        // When
        userDao.save(user);
        int id = user.getId();

        // Then
        Assert.assertNotEquals(0, id);

        // CleanUp
        userDao.delete(id);
    }

}