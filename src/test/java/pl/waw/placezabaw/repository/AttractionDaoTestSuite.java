package pl.waw.placezabaw.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.waw.placezabaw.domain.Attraction;
import pl.waw.placezabaw.domain.AttractionType;
import pl.waw.placezabaw.domain.Playground;
import pl.waw.placezabaw.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttractionDaoTestSuite {
    @Autowired
    AttractionDao attractionDao;
    @Autowired
    PlaygroundDao playgroundDao;
    @Autowired
    AttractionTypeDao attractionTypeDao;
    @Autowired
    UserDao userDao;

    @Test
    public void testSaveAttraction() {
        // Given
        AttractionType attractionType = new AttractionType("test attraction type");
        attractionTypeDao.save(attractionType);
        User user = new User(0, "test user", "login", "pass", "email");
        userDao.save(user);
        Playground playground = new Playground(user, "city", "address", "00-000", 32.22, 23.33, "desc");
        user.getPlaygrounds().add(playground);
        playgroundDao.save(playground);

        Attraction attraction = new Attraction(attractionType, playground, 2, "desc of attraction");
        attractionType.getAttractions().add(attraction);
        playground.getAttractions().add(attraction);
        Attraction attraction2 = new Attraction(attractionType, playground, 3, "description of attraction 2");
        attractionType.getAttractions().add(attraction2);
        playground.getAttractions().add(attraction2);

        // When
        attractionDao.save(attraction);
        int id = attraction.getId();
        attractionDao.save(attraction2);
        int id2 = attraction2.getId();


        // Then
        Assert.assertNotEquals(0, id);
        Assert.assertNotEquals(0, id2);

        // CleanUp
        attractionDao.delete(id);
        attractionDao.delete(id2);

        int userId = user.getId();
        int playgroundId = playground.getId();
        int attractionTypeId = attractionType.getId();
        attractionTypeDao.delete(attractionTypeId);
        playgroundDao.delete(playgroundId);
        userDao.delete(userId);
    }
}