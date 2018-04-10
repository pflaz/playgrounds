package pl.waw.placezabaw.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.waw.placezabaw.Playground;
import pl.waw.placezabaw.Rate;
import pl.waw.placezabaw.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RateDaoTestSuite {
    @Autowired
    RateDao rateDao;

    @Test
    public void testSaveRate() {
        //Given
        User user = new User("username", "login", "pass");
        User user2 = new User("user2", "login2", "pass2");
        Playground playground = new Playground(user, "city", "address", "00-000", 32,32,"desc");
        user.getPlaygrounds().add(playground);
        Rate rate = new Rate(user, playground, 5, "comment");
        user.getRates().add(rate);
        playground.getRates().add(rate);
        Rate rate2 = new Rate(user2, playground, 4, "");
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

    }
}
