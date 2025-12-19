package services;

import users.*;
import model.*;
import java.util.*;

public class SystemService {

    Scanner input = new Scanner(System.in);

    List<Student> students = new ArrayList<>();
    List<Instructor> instructors = new ArrayList<>();
    List<Administrator> admins = new ArrayList<>();
    List<Course> courses = new ArrayList<>();
    List<Section> sections = new ArrayList<>();

    public void seedData(){
        Instructor ins = new Instructor("I1","Dr. Ahmed","ahmed@mail.com");
        Instructor ins2 = new Instructor("I2","Dr. Sara","sara@mail.com");
        Instructor ins3 = new Instructor("I3","Dr. Sameh","sameh@mail.com");
        instructors.add(ins);
        instructors.add(ins2);
        instructors.add(ins3);

        Course c1 = new Course("CS101","Introduction to Computer Science",3);
        Course c2 = new Course("CS102","Object-Oriented Programming",3);
        Course c3 = new Course("SW301","Object-Oriented Analysis and Design",3);
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

        sections.add(new Section("S1",c1,ins,30));
        sections.add(new Section("S2",c2,ins2,20));
        sections.add(new Section("S3",c3,ins3,20));

        students.add(new Student("S1","Ahmad","ahmad@mail.com","CS"));
        students.add(new Student("S2","Sameh","sameh@mail.com","SWAPD"));
        students.add(new Student("S3","Seif","seif@mail.com","SWAPD"));
        students.add(new Student("S4","anyName","anyName@mail.com","SWAPD"));


        admins.add(new Administrator("A1","System Admin","admin@mail.com"));
    }

    public void mainMenu(){
        while(true){
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Student");
            System.out.println("2. Instructor");
            System.out.println("3. Administrator");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = input.nextInt();

            switch(choice){
                case 1 -> studentMenu();
                case 2 -> instructorMenu();
                case 3 -> adminMenu();
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    // ================= STUDENT MENU =================
    void studentMenu(){
        Student s = selectStudent();
        if(s == null) return;

        while(true){
            System.out.println("\n--- STUDENT MENU ("+s.getName()+") ---");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register Course");
            System.out.println("3. View My Schedule");
            System.out.println("4. Back");
            System.out.print("Choose: ");

            int ch = input.nextInt();

            if(ch==1) listSections();
            else if(ch==2) registerStudent(s);
            else if(ch==3) s.getSchedule().viewSchedule();
            else break;
        }
    }

    void listSections(){
        System.out.println("\n--- Available Sections ---");
        for(Section sec : sections){
            System.out.println(sec);
        }
    }

    void registerStudent(Student s){
        listSections();
        System.out.print("Enter Section ID: ");
        String id = input.next();

        for(Section sec : sections){
            if(sec.getSectionId().equals(id)){
                if(sec.hasSeat()){
                    sec.enrollStudent(s);
                    s.getSchedule().addSection(sec);
                    System.out.println("Registered Successfully!");
                } else {
                    System.out.println("Section FULL!");
                }
                return;
            }
        }

        System.out.println("Section not found!");
    }

    // ================= INSTRUCTOR MENU =================
    void instructorMenu(){
        Instructor ins = selectInstructor();
        if(ins == null) return;

        while(true){
            System.out.println("\n--- INSTRUCTOR MENU ("+ins.getName()+") ---");
            System.out.println("1. View My Sections");
            System.out.println("2. View Students in Section");
            System.out.println("3. Back");
            System.out.print("Choose: ");

            int ch = input.nextInt();

            if(ch==1) listInstructorSections(ins);
            else if(ch==2) viewStudentsInSection(ins);
            else break;
        }
    }

    void listInstructorSections(Instructor ins){
        System.out.println("\n--- Your Sections ---");
        for(Section s : sections){
            if(s.getInstructor()==ins)
                System.out.println(s);
        }
    }

    void viewStudentsInSection(Instructor ins){
        System.out.print("Enter Section ID: ");
        String id = input.next();

        for(Section s : sections){
            if(s.getSectionId().equals(id) && s.getInstructor()==ins){
                System.out.println("--- Enrolled Students ---");
                if(s.getEnrolled().isEmpty())
                    System.out.println("No students.");
                else
                    s.getEnrolled().forEach(System.out::println);
                return;
            }
        }

        System.out.println("Section not found or not yours!");
    }

    // ================= ADMIN MENU =================
    void adminMenu(){
        Administrator admin = selectAdmin();
        if(admin == null) return;

        while(true){
            System.out.println("\n--- ADMIN MENU ("+admin.getName()+") ---");
            System.out.println("1. Add Course");
            System.out.println("2. Add Section");
            System.out.println("3. Add Student");
            System.out.println("4. Add Instructor");
            System.out.println("5. Add Administrator");
            System.out.println("6. View All Users");
            System.out.println("7. Remove User");
            System.out.println("8. Back");
            System.out.print("Choose: ");

            int ch = input.nextInt();

            if(ch==1) addCourse();
            else if(ch==2) addSection();
            else if(ch==3) addStudent();
            else if(ch==4) addInstructor();
            else if(ch==5) addAdministrator();
            else if(ch==6) viewAllUsers();
            else if(ch==7) removeUser();
            else break;
        }
    }

    void addCourse(){
        System.out.print("Course Code: ");
        String code = input.next();
        System.out.print("Title: ");
        String title = input.next();
        System.out.print("Credits: ");
        int cr = input.nextInt();

        courses.add(new Course(code,title,cr));
        System.out.println("Course Added!");
    }

    void addSection(){
        listCourses();
        System.out.print("Section ID: ");
        String id = input.next();
        System.out.print("Course Code: ");
        String code = input.next();

        Course c = null;
        for(Course cc : courses)
            if(cc.getCode().equals(code))
                c = cc;

        if(c==null){
            System.out.println("Course not found!");
            return;
        }

        sections.add(new Section(id,c,instructors.get(0),3));
        System.out.println("Section Created!");
    }

    void listCourses(){
        System.out.println("\n--- Courses ---");
        for(Course c : courses)
            System.out.println(c);
    }

    // ================= USER SELECTION =================
    Student selectStudent(){
        if(students.isEmpty()){
            System.out.println("No students in the system!");
            return null;
        }

        System.out.println("\n--- Select Student ---");
        for(int i=0; i<students.size(); i++){
            System.out.println((i+1) + ". " + students.get(i).getName() + " (" + students.get(i).getUserId() + ")");
        }
        System.out.print("Choose student (0 to cancel): ");
        int choice = input.nextInt();

        if(choice <= 0 || choice > students.size()){
            System.out.println("Login cancelled.");
            return null;
        }

        return students.get(choice-1);
    }

    Instructor selectInstructor(){
        if(instructors.isEmpty()){
            System.out.println("No instructors in the system!");
            return null;
        }

        System.out.println("\n--- Select Instructor ---");
        for(int i=0; i<instructors.size(); i++){
            System.out.println((i+1) + ". " + instructors.get(i).getName() + " (" + instructors.get(i).getUserId() + ")");
        }
        System.out.print("Choose instructor (0 to cancel): ");
        int choice = input.nextInt();

        if(choice <= 0 || choice > instructors.size()){
            System.out.println("Login cancelled.");
            return null;
        }

        return instructors.get(choice-1);
    }

    Administrator selectAdmin(){
        if(admins.isEmpty()){
            System.out.println("No administrators in the system!");
            return null;
        }

        System.out.println("\n--- Select Administrator ---");
        for(int i=0; i<admins.size(); i++){
            System.out.println((i+1) + ". " + admins.get(i).getName() + " (" + admins.get(i).getUserId() + ")");
        }
        System.out.print("Choose administrator (0 to cancel): ");
        int choice = input.nextInt();

        if(choice <= 0 || choice > admins.size()){
            System.out.println("Login cancelled.");
            return null;
        }

        return admins.get(choice-1);
    }

    // ================= USER MANAGEMENT =================
    void addStudent(){
        System.out.print("Student ID: ");
        String id = input.next();
        input.nextLine(); // consume newline
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.next();
        System.out.print("Program: ");
        String program = input.next();

        students.add(new Student(id, name, email, program));
        System.out.println("Student added successfully!");
    }

    void addInstructor(){
        System.out.print("Instructor ID: ");
        String id = input.next();
        input.nextLine(); // consume newline
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.next();

        instructors.add(new Instructor(id, name, email));
        System.out.println("Instructor added successfully!");
    }

    void addAdministrator(){
        System.out.print("Administrator ID: ");
        String id = input.next();
        input.nextLine(); // consume newline
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.next();

        admins.add(new Administrator(id, name, email));
        System.out.println("Administrator added successfully!");
    }

    void viewAllUsers(){
        System.out.println("\n===== ALL USERS =====");
        
        System.out.println("\n--- Students ---");
        if(students.isEmpty()) System.out.println("No students.");
        else students.forEach(System.out::println);

        System.out.println("\n--- Instructors ---");
        if(instructors.isEmpty()) System.out.println("No instructors.");
        else instructors.forEach(System.out::println);

        System.out.println("\n--- Administrators ---");
        if(admins.isEmpty()) System.out.println("No administrators.");
        else admins.forEach(System.out::println);
    }

    void removeUser(){
        System.out.println("\n--- Remove User ---");
        System.out.println("1. Remove Student");
        System.out.println("2. Remove Instructor");
        System.out.println("3. Remove Administrator");
        System.out.print("Choose: ");
        int type = input.nextInt();

        switch(type){
            case 1 -> removeStudent();
            case 2 -> removeInstructor();
            case 3 -> removeAdministrator();
            default -> System.out.println("Invalid choice.");
        }
    }

    void removeStudent(){
        if(students.isEmpty()){
            System.out.println("No students to remove.");
            return;
        }

        System.out.println("\n--- Students ---");
        for(int i=0; i<students.size(); i++){
            System.out.println((i+1) + ". " + students.get(i));
        }
        System.out.print("Select student to remove (0 to cancel): ");
        int choice = input.nextInt();

        if(choice > 0 && choice <= students.size()){
            Student removed = students.remove(choice-1);
            System.out.println("Removed: " + removed.getName());
        } else {
            System.out.println("Cancelled.");
        }
    }

    void removeInstructor(){
        if(instructors.isEmpty()){
            System.out.println("No instructors to remove.");
            return;
        }

        System.out.println("\n--- Instructors ---");
        for(int i=0; i<instructors.size(); i++){
            System.out.println((i+1) + ". " + instructors.get(i));
        }
        System.out.print("Select instructor to remove (0 to cancel): ");
        int choice = input.nextInt();

        if(choice > 0 && choice <= instructors.size()){
            Instructor removed = instructors.remove(choice-1);
            System.out.println("Removed: " + removed.getName());
        } else {
            System.out.println("Cancelled.");
        }
    }

    void removeAdministrator(){
        if(admins.isEmpty()){
            System.out.println("No administrators to remove.");
            return;
        }

        if(admins.size() == 1){
            System.out.println("Cannot remove the last administrator!");
            return;
        }

        System.out.println("\n--- Administrators ---");
        for(int i=0; i<admins.size(); i++){
            System.out.println((i+1) + ". " + admins.get(i));
        }
        System.out.print("Select administrator to remove (0 to cancel): ");
        int choice = input.nextInt();

        if(choice > 0 && choice <= admins.size()){
            Administrator removed = admins.remove(choice-1);
            System.out.println("Removed: " + removed.getName());
        } else {
            System.out.println("Cancelled.");
        }
    }
}
