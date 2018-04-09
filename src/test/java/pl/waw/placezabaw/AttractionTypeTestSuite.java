package pl.waw.placezabaw;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.waw.placezabaw.dao.AttractionTypeDao;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttractionTypeTestSuite {

    @Autowired
    AttractionTypeDao attractionTypeDao;

    @Test
    public void testSaveAttractionType() {
        // Given
        AttractionType attractionType = new AttractionType("test attraction type");

        // When
        attractionTypeDao.save(attractionType);
        int id = attractionType.getId();

        // Then
        Assert.assertNotEquals(0, attractionType);

        //CleanUp
        attractionTypeDao.delete(id);
    }
}