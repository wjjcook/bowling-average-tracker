package org.example.bowlingaveragetracker.service;

import org.example.bowlingaveragetracker.model.User;
import org.example.bowlingaveragetracker.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("No user with ID " + id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new UserNotFoundException("No user with ID " + id);
        }
        repo.deleteById(id);
    }
}
