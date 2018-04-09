package pl.waw.placezabaw;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.waw.placezabaw.dao.PlaygroundDao;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaygroundTestSuite {
    @Autowired
    PlaygroundDao playgroundDao;

    @Test
    public void testSavePlayground() {
        // Given
        User user = new User("username", "login", "password");
        Playground playground = new Playground(user, "City", "Address", "00-000", 52.00, 64.00, "Description");
        user.getPlaygrounds().add(playground);

        // When
        playgroundDao.save(playground);
        int id = playground.getId();

        // Then
        Assert.assertNotEquals(0, id);
        System.out.println("user's playgrounds: " + user.getPlaygrounds().size());

        // CleanUp
//        playgroundDao.delete(id);
    }

}