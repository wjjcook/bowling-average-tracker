package org.example.bowlingaveragetracker.service;

import org.example.bowlingaveragetracker.model.BowlingScore;
import org.example.bowlingaveragetracker.model.User;
import org.example.bowlingaveragetracker.repo.BowlingScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BowlingScoreService {
    @Autowired
    private BowlingScoreRepo repo;

    public List<BowlingScore> getScoresByUser(User user) {
        return repo.findByUser(user);
    }

    public void saveBowlingScore(BowlingScore score) {
        repo.save(score);
    }
}
