package org.example.bowlingaveragetracker.repo;

import org.example.bowlingaveragetracker.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
}
