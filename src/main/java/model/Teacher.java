package model;

import java.util.*;

public class Teacher extends Staff {
    List<String> coursesTaught;

    public Teacher(String name, String gender, int age, String contact, String address, String jobTitle) {
        super(name, gender, age, contact, address, jobTitle);
        this.coursesTaught = new ArrayList<>();
    }

    public List<String> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<String> courseTaught) {
        this.coursesTaught = courseTaught;
    }

    // Add courseCode to list of courses taught by teacher
    public void teachCourse(List<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (courseCode.equals(course.getCourseCode())) {
                coursesTaught.add(courseCode);
                return;
            }
        }
        System.out.println("Invalid courseCode");
    }

    public void removeCourse(String courseCode) {
        coursesTaught.remove(courseCode);
    }

    @Override
    public String info() {
        return super.info() + "\n"
                + "Courses taught: " + Arrays.toString(
                        getCoursesTaught().toArray(new Course[getCoursesTaught().size()]));
    }
}
