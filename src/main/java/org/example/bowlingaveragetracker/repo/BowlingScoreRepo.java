package org.example.bowlingaveragetracker.repo;

import org.example.bowlingaveragetracker.model.BowlingScore;
import org.example.bowlingaveragetracker.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BowlingScoreRepo extends CrudRepository<BowlingScore, Integer> {
    List<BowlingScore> findByUser(User user);
}
