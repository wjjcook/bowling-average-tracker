package org.example.bowlingaveragetracker.controller;

import org.example.bowlingaveragetracker.model.BowlingScore;
import org.example.bowlingaveragetracker.model.User;
import org.example.bowlingaveragetracker.service.BowlingScoreService;
import org.example.bowlingaveragetracker.service.UserNotFoundException;
import org.example.bowlingaveragetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BowlingScoreController {

    @Autowired
    private BowlingScoreService scoreService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addBowlingScore(@ModelAttribute BowlingScore score) {
        scoreService.saveBowlingScore(score);
        return "redirect:/bowling-scores";
    }

    @GetMapping("/users/{userId}")
    public String getScoresByUser(@PathVariable Integer userId, Model model, RedirectAttributes ra) {
        try {
            User user = userService.get(userId);
            List<BowlingScore> scores = scoreService.getScoresByUser(user);
            model.addAttribute("scores", scores);
            return "bowling_scores";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }

    }
}
