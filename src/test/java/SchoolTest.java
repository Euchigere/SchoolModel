import model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    School school;
    @org.junit.jupiter.api.BeforeEach
    void setup() {
        school = new School("Model School");
    }

    @org.junit.jupiter.api.Test
    void getMAX_AGETest() {
        // test getMAX_AGE method returns expected value
        int actual = school.getMAX_AGE();
        int expected = 16;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getMIN_AGETest() {
        int actual = school.getMIN_AGE();
        int expected = 10;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getNameTest() {
        String actual = school.getName();
        String expected = "Model School";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void setNameTest() {
        school.setName("Decagon Institute");
        String actual = school.getName();
        String expected = "Decagon Institute";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getStaffsTestAndSetStaffTest() {
        Teacher teacher = new Teacher("Chibueze", "m", 29,
                "07075643341", "No. 6 Asajon way", "Teacher");
        Principal principal = new Principal("Chika", "m", 40,
                "08060342565", "No. 6 Asajon way", "Principal");
        NonAcademicStaff nonAcademicStaff = new NonAcademicStaff("Kemi", "f", 35,
                "08130578625", "No. 6 Asajon way", "Cook");
        StaffOffice staffs = new StaffOffice();
        staffs.setPrincipal(principal);
        staffs.addTeacher(teacher);
        staffs.addNonAcademicStaff(nonAcademicStaff);
        school.setStaffs(staffs);
        StaffOffice actual = school.getStaffs();
        StaffOffice expected = staffs;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getStudentsTestAndSetStudentsTest() {
        Student student1 = new Student("Solomon", "m", 14, "07089675436",
                "No. 6 Asajon Way", Grade.CLASS_3.toString(), "0001");
        Student student2 = new Student("Emelda", "f", 13, "07067975643",
                "No. 6 Asajon Way", Grade.CLASS_2.toString(), "0002");
        List <Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student1);
        school.setStudents(students);
        List<Student> actual = school.getStudents();
        List<Student> expected = students;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getApplicantTestAndSetApplicantTest() {
        Applicant applicant = new Applicant("Emelda", "f", 13, "07067975643",
                "No. 6 Asajon Way", Grade.CLASS_2.toString());
        school.setApplicant(applicant);
        Applicant actual = school.getApplicant();
        Applicant expected = applicant;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void expelStudentTest() {
        //create principal object
        Principal principal = new Principal("Chika", "m", 40,
                "08060342565", "No. 6 Asajon way", "Principal");

        //create staffOffice object and set principal object
        StaffOffice staffs = new StaffOffice();
        staffs.setPrincipal(principal);
        school.setStaffs(staffs); // set staff office in school object

        // create two new student objects and add to school object student list
        Student student1 = new Student("Solomon", "m", 14, "07089675436",
                "No. 6 Asajon Way", Grade.CLASS_3.toString(), "0001");
        Student student2 = new Student("Emelda", "f", 13, "07067975643",
                "No. 6 Asajon Way", Grade.CLASS_2.toString(), "0002");
        List <Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student1);
        school.setStudents(students);

        school.expelStudent("0001");
        List <Student> actual = school.getStudents();

        students.remove(student1);
        List <Student> expected = students;

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void createCourseTest() {
        school.createCourse("BIO 001", "Biology");
        school.createCourse("MATH 101", "Mathematics");
        Course actual1 = school.getCourses().get(0);
        Course actual2 = school.getCourses().get(1);

        // create expected List<Course> object;
        Course expected1 = new Course("BIO 001", "Biology");
        Course expected2 = new Course("MATH 101", "Mathematics");

        assertAll(
                () -> assertEquals(expected1.getName(), actual1.getName()),
                () -> assertEquals(expected1.getCourseCode(), actual1.getCourseCode()),
                () -> assertEquals(expected2.getName(), actual2.getName()),
                () -> assertEquals(expected2.getCourseCode(), actual2.getCourseCode())
        );
    }

    @org.junit.jupiter.api.Test
    void applicantWithValidAgeTest() {
        //create principal object
        Principal principal = new Principal("Chika", "m", 40,
                "08060342565", "No. 6 Asajon way", "Principal");

        //create staffOffice object and set principal object
        StaffOffice staffs = new StaffOffice();
        staffs.setPrincipal(principal);
        school.setStaffs(staffs); // set staff office in school object

        school.application("Emelda", "f", 13, "07067975643",
                "No. 6 Asajon Way", Grade.CLASS_2.toString());
        Student actual = school.getStudents().get(0);

        //create expected student object
        Student expected = new Student("Emelda", "f", 13, "07067975643",
                "No. 6 Asajon Way", Grade.CLASS_2.toString(), "0001");

        assertAll(
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getGender(), actual.getGender()),
                () -> assertEquals(expected.getAge(), actual.getAge()),
                () -> assertEquals(expected.getContact(), actual.getContact()),
                () -> assertEquals(expected.getAddress(), actual.getAddress()),
                () -> assertEquals(expected.getID(), actual.getID()),
                () -> assertEquals(expected.getGrade(), actual.getGrade())
        );
    }

    @org.junit.jupiter.api.Test
    void applicantWithInvalidAgeTest() {
        //create principal object
        Principal principal = new Principal("Chika", "m", 40,
                "08060342565", "No. 6 Asajon way", "Principal");

        //create staffOffice object and set principal object
        StaffOffice staffs = new StaffOffice();
        staffs.setPrincipal(principal);
        school.setStaffs(staffs); // set staff office in school object

        //create applicant object with invalid age
        school.application("Josh", "m", 20, "07067975643",
                "No. 6 Asajon Way", Grade.CLASS_2.toString());

        List<Student> actual1 = school.getStudents();
        List<Student> expected = new ArrayList<>();

        assertEquals(expected, actual1);

        // Another spplicant
        school.application("Mirabel", "f", 9, "07067975643",
                "No. 6 Asajon Way", Grade.CLASS_2.toString());

        List<Student> actual2 = school.getStudents();

        assertEquals(expected, actual2);
    }

    @org.junit.jupiter.api.Test
    void employPrincipalWhenThereIsNoPrincipalTest() {
        school.employStaff("Principal", "Nkem", "f", 35,
                "08060342565", "No. 6 Asajon way");
        Principal actual = school.getStaffs().getPrincipal();

        Principal expected = new Principal("Nkem", "f", 35,
                "08060342565", "No. 6 Asajon way", "Principal");

        assertAll(
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getGender(), actual.getGender()),
                () -> assertEquals(expected.getAge(), actual.getAge()),
                () -> assertEquals(expected.getContact(), actual.getContact()),
                () -> assertEquals(expected.getAddress(), actual.getAddress()),
                () -> assertEquals(expected.getJobTitle(), actual.getJobTitle())
        );
    }

    @org.junit.jupiter.api.Test
    void employPrincipalWhenThereIsAPrincipalTest() {
        school.employStaff("Principal", "Chika", "m", 40,
                "08060342565", "No. 6 Asajon way");

        school.employStaff("Principal", "Nkem", "f", 35,
                "08060342565", "No. 6 Asajon way");
        Principal actual = school.getStaffs().getPrincipal();

        Principal notExpected = new Principal("Nkem", "f", 35,
                "08060342565", "No. 6 Asajon way", "Principal");

        assertNotEquals(notExpected, actual);
    }

    @org.junit.jupiter.api.Test
    void employTeacherTest() {
        school.employStaff("Teacher", "Prince", "m", 30,
                "09078453724", "No. 6 Asajon way");
        Teacher actual = school.getStaffs().getTeachers().get(0);

        Teacher expected = new Teacher("Prince", "m", 30,
                "09078453724", "No. 6 Asajon way", "Teacher");

        assertAll(
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getGender(), actual.getGender()),
                () -> assertEquals(expected.getAge(), actual.getAge()),
                () -> assertEquals(expected.getContact(), actual.getContact()),
                () -> assertEquals(expected.getAddress(), actual.getAddress()),
                () -> assertEquals(expected.getJobTitle(), actual.getJobTitle())
        );
    }

    @org.junit.jupiter.api.Test
    void employNonAcademicStaffTest() {
        school.employStaff("Gate man", "Musa", "m", 35,
                "070536795", "No. 6 Asajon way");
        NonAcademicStaff actual = school.getStaffs().getNonAcademicStaffs().get(0);

        NonAcademicStaff expected = new NonAcademicStaff("Musa", "m", 35,
                "070536795", "No. 6 Asajon way", "Gate man");

        assertAll(
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getGender(), actual.getGender()),
                () -> assertEquals(expected.getAge(), actual.getAge()),
                () -> assertEquals(expected.getContact(), actual.getContact()),
                () -> assertEquals(expected.getAddress(), actual.getAddress()),
                () -> assertEquals(expected.getJobTitle(), actual.getJobTitle())
        );
    }
}