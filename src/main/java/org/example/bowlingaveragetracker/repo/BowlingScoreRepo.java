package org.example.bowlingaveragetracker.repo;

import org.example.bowlingaveragetracker.model.BowlingScore;
import org.springframework.data.repository.CrudRepository;

public interface BowlingScoreRepo extends CrudRepository<BowlingScore, Integer> {
}
