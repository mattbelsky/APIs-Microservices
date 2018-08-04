package ExerciseTracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ExerciseController {

    Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    @Autowired
    ExerciseMapper exerciseMapper;

    @Autowired
    ExerciseService exerciseService;

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("exercise", new Exercise());
        return "home";
    }

    @PostMapping("/api/exercise/new-user")
    public String addUser(@ModelAttribute User user) {
        exerciseMapper.addUser(user.getUsername());
        logger.info("New user added successfully.");
        return "redirect:/home";
    }

    @PostMapping("/api/exercise/add")
    public String addExercise(@ModelAttribute Exercise exercise) {

        if (exerciseService.validateUser(exercise.getUsername())) {

            exerciseMapper.addExercise(exercise);
            logger.info("New exercise added successfully.");

        } else logger.error("Invalid user.");

        return "redirect:/home";
    }

    @GetMapping("/api/exercise/log")
    public String getExercisesByUserAndDate(@RequestParam("username") String username,
                                            @RequestParam("from") String from,
                                            @RequestParam("to") String to,
                                            @RequestParam("limit") int limit,
                                            Model model) {

        ArrayList<Exercise> exercises = exerciseMapper.getExercisesByUserAndDate(username, from, to, limit);
        model.addAttribute("exercises", exercises);
        return "exercises";
    }
}
