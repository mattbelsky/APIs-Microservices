package ExerciseTracker;

public class Exercise {

    int id;
    String username;
    String description;
    double duration;
    String date;

    public Exercise(String username, String description, double duration, String date) {
        this.username = username;
        this.description = description;
        this.duration = duration;
        this.date = date;
    }

    public Exercise() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
