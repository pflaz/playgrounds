package pl.waw.placezabaw.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.waw.placezabaw.Playground;
import pl.waw.placezabaw.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaygroundDaoTestSuite {
    @Autowired
    PlaygroundDao playgroundDao;
    @Autowired
    UserDao userDao;

    @Test
    public void testSavePlayground() {
        // Given
        User user = new User("username", "login", "password", "email");
        userDao.save(user);
        Playground playground = new Playground(user, "City", "Address", "00-000", 52.00, 64.00, "Description");
        Playground playground2 = new Playground(user, "city2", "address2", "11-111", 12, 12, "desc2");
        user.getPlaygrounds().add(playground);
        user.getPlaygrounds().add(playground2);

        // When
        playgroundDao.save(playground);
        int id = playground.getId();
        playgroundDao.save(playground2);
        int id2 = playground2.getId();

        // Then
        Assert.assertNotEquals(0, id);
        Assert.assertNotEquals(0, id2);

        // CleanUp
        playgroundDao.delete(id);
        playgroundDao.delete(id2);
        int userId = user.getId();
        userDao.delete(userId);

    }

}