package pl.waw.placezabaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.waw.placezabaw.domain.UserDto;
import pl.waw.placezabaw.mapper.UserMapper;
import pl.waw.placezabaw.service.DbService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {
    @Autowired
    private DbService dbService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(dbService.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam Integer userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(dbService.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        dbService.saveUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(dbService.saveUser(userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(@RequestParam Integer userId) {
        dbService.deleteUser(userId);
    }
}
