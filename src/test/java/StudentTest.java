import model.Course;
import model.Grade;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StudentTest {
    Student student;
    @BeforeEach
    void setUp() {
        student = new Student("Solomon", "m", 14, "07089675436",
                "No. 6 Asajon Way", Grade.CLASS_3.toString(), "0001");
    }

    @Test
    void takeCourseWhenCourseIsInCourseListTest() {
        Course course1 = new Course("BIO 001", "Biology");
        Course course2 = new Course("MATH 101", "Mathematics");
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        student.takeCourse(courses, "BIO 001");
        student.takeCourse(courses, "MATH 101");

        List<String> actual = student.getCourses();

        String[] expectedArray = {course1.getCourseCode(), course2.getCourseCode()};
        List<String> expectedListArray = Arrays.asList(expectedArray);

        assertEquals(expectedListArray, actual);
    }

    @Test
    void takeCourseWhenCourseIsNotInCourseListTest() {
        Course course1 = new Course("BIO 001", "Biology");
        Course course2 = new Course("MATH 101", "Mathematics");
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        student.takeCourse(courses, "BIO 001");
        student.takeCourse(courses, "MATH 110");

        List<String> actual = student.getCourses();

        String[] expectedArray = {course1.getCourseCode(), course2.getCourseCode()};
        List<String> expectedListArray = Arrays.asList(expectedArray);

        assertNotEquals(expectedListArray, actual);

    }

    @Test
    void removeCourseTest() {
        Course course1 = new Course("BIO 001", "Biology");
        Course course2 = new Course("MATH 101", "Mathematics");
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        student.takeCourse(courses, "BIO 001");
        student.takeCourse(courses, "MATH 101");
        student.removeCourse("MATH 101");

        List<String> actual = student.getCourses();

        String[] expectedArray = {course1.getCourseCode()};
        List<String> expectedListArray = Arrays.asList(expectedArray);

        assertEquals(expectedListArray, actual);
    }

    @Test
    void TestInfoMethodAndConsequentiallyAllTheGetters() {
        String actualInfo = student.info();

        String expectedInfo = "Name: Solomon\n"
                + "Gender: Male\n"
                + "Age: 14\n"
                + "Contact: 07089675436\n"
                + "Address: No. 6 Asajon Way\n"
                + "ID: 0001\n"
                + "Grade: Js3\n"
                + "Courses taken: []";

        assertEquals(expectedInfo, actualInfo);
    }
}