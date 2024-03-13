package org.example.bowlingaveragetracker;

import org.assertj.core.api.Assertions;
import org.example.bowlingaveragetracker.model.BowlingScore;
import org.example.bowlingaveragetracker.model.User;
import org.example.bowlingaveragetracker.repo.BowlingScoreRepo;
import org.example.bowlingaveragetracker.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BowlingScoreRepoTests {
    @Autowired
    private BowlingScoreRepo scoreRepo;

    @Autowired
    private UserRepo userRepo;

    @Test
    public void testAddNew() {
        Integer userId = 17;
        Optional<User> optionalUser = userRepo.findById(userId);
        User user = optionalUser.get();

        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getId()).isGreaterThan(0);

        BowlingScore score = new BowlingScore();
        score.setUser(user);
        BowlingScore savedScore = scoreRepo.save(score);

        Assertions.assertThat(savedScore).isNotNull();
        Assertions.assertThat(savedScore.getId()).isGreaterThan(0);
    }
}