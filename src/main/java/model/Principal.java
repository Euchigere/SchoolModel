package model;

import java.util.*;

public class Principal extends Staff{
    public Principal(String name, String gender, int age, String contact, String address, String jobTitle) {
        super(name, gender, age, contact, address, jobTitle);
    }

    public boolean admit(Applicant applicant, int maxAge, int minAge) {
        return applicant.getAge() >= minAge && applicant.getAge() <= maxAge;
    }

    public void expelStudent(List<Student> students, String studentId) {
        for (Student student : students) {
            if (student.getID().equals(studentId)) {
                students.remove(student);
                return;
            }
        }
        System.out.println("Invalid Id");
    }
}
