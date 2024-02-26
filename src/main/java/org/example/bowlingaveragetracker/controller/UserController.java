package org.example.bowlingaveragetracker.controller;

import org.example.bowlingaveragetracker.model.User;
import org.example.bowlingaveragetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public User getUser(@RequestParam Integer id){
        return userService.getUser(id);
    }

}
