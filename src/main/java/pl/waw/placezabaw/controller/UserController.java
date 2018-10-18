package pl.waw.placezabaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.waw.placezabaw.domain.UserDto;
import pl.waw.placezabaw.exceptions.UserNotFoundException;
import pl.waw.placezabaw.mapper.UserMapper;
import pl.waw.placezabaw.service.DbService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {
    private DbService dbService;
    private UserMapper userMapper;

    @Autowired
    public UserController(DbService dbService, UserMapper userMapper) {
        this.dbService = dbService;
        this.userMapper = userMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(dbService.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public UserDto getUser(@PathVariable Integer userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(dbService.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(dbService.saveUser(userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE, value = "/{userId}")
    public UserDto updateUser(@PathVariable int userId, @RequestBody UserDto userDto) throws UserNotFoundException {
        return userMapper.mapToUserDto(dbService.updateUser(userId, userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam Integer userId) {
        dbService.deleteUser(userId);
    }
}
