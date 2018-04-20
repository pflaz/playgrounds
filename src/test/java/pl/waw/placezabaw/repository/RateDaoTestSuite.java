package pl.waw.placezabaw.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.waw.placezabaw.domain.Playground;
import pl.waw.placezabaw.domain.Rate;
import pl.waw.placezabaw.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RateDaoTestSuite {
    @Autowired
    RateDao rateDao;
    @Autowired
    UserDao userDao;
    @Autowired
    PlaygroundDao playgroundDao;

    @Test
    public void testSaveRate() {
        //Given
        User user = new User(0,"username", "login", "pass", "email");
        userDao.save(user);
        User user2 = new User(0,"user2", "login2", "pass2", "email");
        userDao.save(user2);
        Playground playground = new Playground(0,user, "city", "address", "00-000", 32,32,"desc");
        user.getPlaygrounds().add(playground);
        playgroundDao.save(playground);
        Rate rate = new Rate(0,user, playground, 5, "comment");
        user.getRates().add(rate);
        playground.getRates().add(rate);
        Rate rate2 = new Rate(0,user2, playground, 4, "");
        user2.getRates().add(rate2);
        playground.getRates().add(rate2);

        // When
        rateDao.save(rate);
        int id1 = rate.getId();
        rateDao.save(rate2);
        int id2 = rate2.getId();

        // Then
        Assert.assertNotEquals(0, id1);
        Assert.assertNotEquals(0, id2);

        // CleanUp
        rateDao.delete(id1);
        rateDao.delete(id2);
        int playgroundId = playground.getId();
        playgroundDao.delete(playgroundId);
        int userId = user.getId();
        int user2Id = user2.getId();
        userDao.delete(userId);
        userDao.delete(user2Id);

    }
}
