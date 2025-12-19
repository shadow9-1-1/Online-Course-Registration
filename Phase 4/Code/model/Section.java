package model;

import users.Student;
import users.Instructor;
import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionId;
    private Course course;
    private Instructor instructor;
    private int capacity;
    private List<Student> enrolled;

    public Section(String sectionId, Course course, Instructor instructor, int capacity){
        this.sectionId = sectionId;
        this.course = course;
        this.instructor = instructor;
        this.capacity = capacity;
        this.enrolled = new ArrayList<>();
    }

    public String getSectionId(){ return sectionId; }
    public Course getCourse(){ return course; }
    public Instructor getInstructor(){ return instructor; }
    public List<Student> getEnrolled(){ return enrolled; }

    public boolean hasSeat(){
        return enrolled.size() < capacity;
    }

    public boolean enrollStudent(Student s){
        if(hasSeat()){
            enrolled.add(s);
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return sectionId + " | " + course + " | Instructor: " +
                instructor.getName() + " | Seats: " + enrolled.size() + "/" + capacity;
    }
}
