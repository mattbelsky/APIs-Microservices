package ExerciseTracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class AppRunner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    ExerciseMapper exerciseMapper;

    @Override
    public void run(String[] args) {
        exerciseMapper.getAllUsers();
        logger.info("User list cached.");
    }
}
