package pl.waw.placezabaw.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.waw.placezabaw.domain.Playground;
import pl.waw.placezabaw.domain.Rate;
import pl.waw.placezabaw.domain.RateDto;
import pl.waw.placezabaw.domain.User;
import pl.waw.placezabaw.exceptions.PlaygroundNotFoundException;
import pl.waw.placezabaw.exceptions.UserNotFoundException;
import pl.waw.placezabaw.service.PlaygroundDbService;
import pl.waw.placezabaw.service.UserDbService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RateMapper {

    private UserDbService userDbService;
    private PlaygroundDbService playgroundDbService;

    @Autowired
    public RateMapper(UserDbService userDbService, PlaygroundDbService playgroundDbService) {
        this.userDbService = userDbService;
        this.playgroundDbService = playgroundDbService;
    }

    public RateDto mapToRateDto(Rate rate) {
        return new RateDto(
                rate.getId(),
                rate.getUser().getId(),
                rate.getPlayground().getId(),
                rate.getRate(),
                rate.getComment(),
                rate.getRatedDateTime()
        );
    }

    public List<RateDto> mapToRateDtoList(List<Rate> rateList) {
        return rateList.stream()
                .map(this::mapToRateDto)
                .collect(Collectors.toList());
    }

    public Rate mapToRate(RateDto rateDto) throws UserNotFoundException, PlaygroundNotFoundException {

        User user = userDbService.get(rateDto.getUserId()).orElseThrow(UserNotFoundException::new);
        Playground playground = playgroundDbService.getPlayground(rateDto.getPlaygroundId()).orElseThrow(PlaygroundNotFoundException::new);
        return new Rate(
                rateDto.getId(),
                user,
                playground,
                rateDto.getRate(),
                rateDto.getComment(),
                rateDto.getRatedDateTime()
        );
    }
}
