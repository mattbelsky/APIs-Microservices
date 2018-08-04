package ExerciseTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExerciseService {

    @Autowired
    ExerciseMapper exerciseMapper;

    @Cacheable("users")
    public ArrayList<String> getAllUsers() {
        return exerciseMapper.getAllUsers();
    }

    public boolean validateUser(String username) {

        if (getAllUsers().contains(username)) return true;
        else return false;
    }
}
