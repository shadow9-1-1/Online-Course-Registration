package model;

import users.Student;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private Student student;
    private List<Section> registeredSections;

    public Schedule(Student student){
        this.student = student;
        registeredSections = new ArrayList<>();
    }

    public void addSection(Section s){
        registeredSections.add(s);
    }

    public void viewSchedule(){
        if(registeredSections.isEmpty()){
            System.out.println("No registered courses.");
            return;
        }

        System.out.println("Schedule for " + student.getName());
        for(Section s : registeredSections){
            System.out.println(s);
        }
    }
}
