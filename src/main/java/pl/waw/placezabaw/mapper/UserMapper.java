package pl.waw.placezabaw.mapper;

import org.springframework.stereotype.Component;
import pl.waw.placezabaw.domain.Playground;
import pl.waw.placezabaw.domain.Rate;
import pl.waw.placezabaw.domain.User;
import pl.waw.placezabaw.domain.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getEmail()
        );
    }

    public UserDto mapToUserDto(final User user) {
        List<Integer> playgroundsIds;
        playgroundsIds = user.getPlaygrounds().stream()
                .map(Playground::getId)
                .collect(Collectors.toList());

        List<Integer> ratesIds;
        ratesIds = user.getRates().stream()
                .map(Rate::getId)
                .collect(Collectors.toList());
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                playgroundsIds,
                ratesIds
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
