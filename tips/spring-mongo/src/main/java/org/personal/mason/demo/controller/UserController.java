package org.personal.mason.demo.controller;

import org.personal.mason.demo.domain.Role;
import org.personal.mason.demo.domain.User;
import org.personal.mason.demo.dto.UserListDto;
import org.personal.mason.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: masonmei
 * Date: 11/3/12
 * Time: 1:31 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping
    public String getUsersPage() {
        return "users";
    }

    @RequestMapping(value="/records")
    public @ResponseBody
    UserListDto getUsers() {

        UserListDto userListDto = new UserListDto();
        userListDto.setUsers(service.readAll());
        return userListDto;
    }

    @RequestMapping(value="/get")
    public @ResponseBody
    User get(@RequestBody User user) {
        return service.read(user);
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public @ResponseBody User create(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Integer role) {

        Role newRole = new Role();
        newRole.setRole(role);

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setRole(newRole);

        return service.create(newUser);
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public @ResponseBody User update(
            @RequestParam String username,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Integer role) {

        Role existingRole = new Role();
        existingRole.setRole(role);

        User existingUser = new User();
        existingUser.setUsername(username);
        existingUser.setFirstName(firstName);
        existingUser.setLastName(lastName);
        existingUser.setRole(existingRole);

        return service.update(existingUser);
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public @ResponseBody Boolean delete(
            @RequestParam String username) {

        User existingUser = new User();
        existingUser.setUsername(username);

        return service.delete(existingUser);
    }
}
