package pl.waw.placezabaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.waw.placezabaw.domain.Playground;
import pl.waw.placezabaw.repository.PlaygroundDao;

import java.util.List;
import java.util.Optional;

@Service
public class PlaygroundDbService {

    private PlaygroundDao playgroundDao;

    @Autowired
    public PlaygroundDbService(PlaygroundDao playgroundDao) {
        this.playgroundDao = playgroundDao;
    }

    public List<Playground> getAllPlaygrounds() {
        return playgroundDao.findAll();
    }
    public Optional<Playground> getPlayground(final Integer id) {
        return playgroundDao.findById(id);
    }
    public Playground savePlayground(final Playground playground) {
        return playgroundDao.save(playground);
    }
    public void deletePlayground(final Integer id) {
        playgroundDao.delete(id);
    }
}
