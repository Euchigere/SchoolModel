package model;

import java.util.*;

public class Student extends Person {
    private String ID;
    private String grade;
    static List<String> courses;

    public Student(String name, String gender, int age, String contact, String address, String grade, String id) {
        super(name, gender, age, contact, address);
        this.ID = id;
        this.grade = grade;
        this.courses = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        Student.courses = courses;
    }

    // Add courseCode to the list of courses taken by student
    public void takeCourse(List<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (courseCode.equals(course.getCourseCode())) {
                this.courses.add(courseCode);
                return;
            }
        }
        System.out.println("Invalid course code");
    }

    // Remove courseCode from list of courses taken by student
    public void removeCourse(String courseCode) {
        courses.remove(courseCode);
    }

    @Override
    public String info() {
        return super.info() + "\n"
                + "ID: " + getID() + "\n"
                + "Grade: " + getGrade() + "\n"
                + "Courses taken: " + Arrays.toString(getCourses().toArray(new Course[getCourses().size()]));
    }
}
