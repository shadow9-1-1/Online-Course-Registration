package users;

import model.Schedule;

public class Student extends User {
    private String program;
    private int maxCredits;
    private Schedule schedule;

    public Student(String id, String name, String email, String program){
        super(id, name, email, "Student");
        this.program = program;
        this.maxCredits = 18;
        this.schedule = new Schedule(this);
    }

    public Schedule getSchedule(){
        return schedule;
    }
}
