package ExerciseTracker;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ExerciseMapper {

    @Insert("INSERT INTO `exercise-tracker`.`users` (`username`) VALUES (#{username});")
    public int addUser(String username);

    @Insert("INSERT INTO `exercise-tracker`.`exercises` (`username`, `description`, `duration`, `date`) " +
            "VALUES (#{username}, #{description}, #{duration}, #{date});")
    public int addExercise(Exercise exercise);

    @Select("SELECT * FROM `exercise-tracker`.`exercises` WHERE `username` = #{arg0} AND `date` >= #{arg1} " +
            "AND `date` <= #{arg2} LIMIT #{arg3};")
    public ArrayList<Exercise> getExercisesByUserAndDate(String username, String from, String to, int limit);

    @Select("SELECT * FROM `exercise-tracker`.`users` WHERE `username` = #{username};")
    public User getUserByUsername(String username);

    @Select("SELECT `username` FROM `exercise-tracker`.`users`;")
    public ArrayList<String> getAllUsers();
}
