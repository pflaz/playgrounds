package pl.waw.placezabaw.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.waw.placezabaw.Attraction;
import pl.waw.placezabaw.AttractionType;
import pl.waw.placezabaw.Playground;
import pl.waw.placezabaw.User;
import pl.waw.placezabaw.dao.AttractionDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttractionDaoTestSuite {
    @Autowired
    AttractionDao attractionDao;

    @Test
    public void testSaveAttraction() {
        // Given
        AttractionType attractionType = new AttractionType("test attraction type");
        User user = new User("test user", "login", "pass");
        Playground playground = new Playground(user, "city", "address", "00-000", 32.22, 23.33, "desc");
        user.getPlaygrounds().add(playground);
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
    }
}