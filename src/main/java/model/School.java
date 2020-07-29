package model;
import java.util.*;

public class School {
    private int MAX_AGE = 16;
    private final int MIN_AGE = 10;
    private String name;
    private StaffOffice staffs;
    private List<Student> students;
    private List<Course> courses;
    private Applicant applicant;
    private Long idCount;

    public School(String name) {
        this.name = name;
        this.staffs = new StaffOffice();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.idCount = 0l;
    }

    public int getMAX_AGE() {
        return MAX_AGE;
    }

    public int getMIN_AGE() {
        return MIN_AGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StaffOffice getStaffs() {
        return staffs;
    }

    public void setStaffs(StaffOffice staffs) {
        this.staffs = staffs;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Long getIdCount() {
        return ++idCount;
    }

    public String generateId() {
        return String.format("%4s", "" + getIdCount()).replace(' ', '0');
    }

    public void createCourse(String courseCode, String courseName) {
        // create a new course with course constructor
        // and add the course to course list
        Course course = new Course(courseCode, courseName);
        getCourses().add(course);
    }

    public void application(String name, String gender, int age, String contact, String address, String grade) {
        // create a new applicant
        Applicant applicant = new Applicant(name, gender, age, contact, address, grade);
        setApplicant(applicant);
        boolean isAdmitted = getStaffs().getPrincipal().admit(getApplicant(), getMAX_AGE(), getMIN_AGE());
        if (isAdmitted) {
            //use applicant info to create a student and add to student list
            Student student = new Student(applicant.getName(), applicant.getGender(), applicant.getAge(),
                    applicant.getContact(), applicant.getAddress(), applicant.getGrade(), generateId());
            getStudents().add(student);
        }
    }

    public void expelStudent(String studentId) {
        getStaffs().getPrincipal().expelStudent(getStudents(), studentId);
    }

    public void employStaff(String staffType, String name, String gender, int age, String contact, String address) {
        switch (staffType) {
            case "Principal":
                if (getStaffs().getPrincipal() != null) {
                    break;
                }
                // create a principal with principal constructor
                // and add principal to staffOffice class
                Principal principal = new Principal(name, gender, age, contact, address, staffType);
                staffs.setPrincipal(principal);
                break;
            case "Teacher":
                //create a new teacher with teacher constructor
                // and add the teacher to staffOffice teacher list.
                Teacher teacher = new Teacher(name, gender, age, contact, address, staffType);
                staffs.addTeacher(teacher);
                break;
            default:
                // create a nonacademic staff with non academic staff
                // and add the staff to staffOffice nonAcademic staff list;
                NonAcademicStaff nonAcademicStaff = new NonAcademicStaff(name, gender, age, contact, address, staffType);
                staffs.addNonAcademicStaff(nonAcademicStaff);
        }
    }
}
