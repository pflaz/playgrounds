package pl.waw.placezabaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.waw.placezabaw.domain.UserDto;
import pl.waw.placezabaw.exceptions.UserNotFoundException;
import pl.waw.placezabaw.mapper.UserMapper;
import pl.waw.placezabaw.service.UserDbService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {
    private UserDbService dbService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserDbService dbService, UserMapper userMapper) {
        this.dbService = dbService;
        this.userMapper = userMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(dbService.getAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public UserDto getUser(@PathVariable Integer userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(dbService.get(userId).orElseThrow(UserNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        userDto.setId(0);
        return userMapper.mapToUserDto(dbService.save(userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE, value = "/{userId}")
    public UserDto updateUser(@PathVariable int userId, @RequestBody UserDto userDto) throws UserNotFoundException {
        userDto.setId(userId);
        return userMapper.mapToUserDto(dbService.update(userId, userMapper.mapToUser(userDto)));
    }

    @GetMapping(value = "/search")
    public List<UserDto> search(@RequestParam(required = false) String login, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        if (login != null && !login.isEmpty() && name != null && !name.isEmpty() && email != null && !email.isEmpty()) {
            return userMapper.mapToUserDtoList(dbService.findByLoginAndNameAndEmail(login, name, email));
        }
        if (login != null && !login.isEmpty() && name != null && !name.isEmpty()) {
            return userMapper.mapToUserDtoList(dbService.findByLoginAndName(login, name));
        }
        if (name != null && !name.isEmpty() && email != null && !email.isEmpty()) {
            return userMapper.mapToUserDtoList(dbService.findByNameAndEmail(name, email));
        }
        if (login != null && !login.isEmpty() && email != null && !email.isEmpty()) {
            return userMapper.mapToUserDtoList(dbService.findByLoginAndEmail(login, email));
        }
        if (login != null && !login.isEmpty()) {
            return userMapper.mapToUserDtoList(dbService.findByLogin(login));
        }
        if (name != null && !name.isEmpty()) {
            return userMapper.mapToUserDtoList(dbService.findByName(name));
        }
        if (email != null && !email.isEmpty()) {
            return userMapper.mapToUserDtoList(dbService.findByEmail(email));
        }
        return new ArrayList<>();

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteUser(@PathVariable Integer id) {
        dbService.delete(id);
    }
}
