package pl.waw.placezabaw.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.waw.placezabaw.domain.AttractionType;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AttractionTypeDaoTestSuite {

    @Autowired
    AttractionTypeDao attractionTypeDao;

    @Test
    public void testSaveAttractionType() {
        // Given
        AttractionType attractionType = new AttractionType(0,"test attraction type");

        // When
        attractionTypeDao.save(attractionType);
        int id = attractionType.getId();

        // Then
        Assert.assertNotEquals(0, attractionType);

        //CleanUp
        attractionTypeDao.delete(id);
    }
}