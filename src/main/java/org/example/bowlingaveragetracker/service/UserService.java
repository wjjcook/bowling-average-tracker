package org.example.bowlingaveragetracker.service;

import org.example.bowlingaveragetracker.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    private List<User> userList;
    public UserService(){
        userList = new ArrayList<>();
    }
    public Optional<User> getUser(Integer id) {
        Optional<User> optional = Optional.empty();
        for (User user: userList){
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return Optional.empty();
    }
}
