import model.Course;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TeacherTest {
    Teacher teacher;
    @BeforeEach
    void setUp() {
        teacher = new Teacher("Prince", "m", 30,
                "09078453724", "No. 6 Asajon way", "Teacher");
    }

    @Test
    void teachCourseWhenCourseIsInCourseListTest() {
        Course course1 = new Course("BIO 001", "Biology");
        Course course2 = new Course("MATH 101", "Mathematics");
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        teacher.teachCourse(courses, "BIO 001");
        teacher.teachCourse(courses, "MATH 101");

        List<String> actualListArray = teacher.getCoursesTaught();

        String[] expectedArray = {course1.getCourseCode(), course2.getCourseCode()};
        List<String> expectedListArray = Arrays.asList(expectedArray);

        assertEquals(expectedListArray, actualListArray);

    }

    @Test
    void teachCourseWhenCourseIsNotInCourseListTest() {
        Course course1 = new Course("BIO 001", "Biology");
        Course course2 = new Course("MATH 101", "Mathematics");
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        teacher.teachCourse(courses, "BIO 001");
        teacher.teachCourse(courses, "MATH 111");

        List<String> actualListArray = teacher.getCoursesTaught();

        String[] expectedArray = {course1.getCourseCode(), course2.getCourseCode()};
        List<String> expectedListArray = Arrays.asList(expectedArray);

        assertNotEquals(expectedListArray, actualListArray);
    }

    @Test
    void removeCourse() {
        Course course1 = new Course("BIO 001", "Biology");
        Course course2 = new Course("MATH 101", "Mathematics");
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        teacher.teachCourse(courses, "BIO 001");
        teacher.teachCourse(courses, "MATH 101");
        teacher.removeCourse("MATH 101");

        List<String> actual = teacher.getCoursesTaught();

        String[] expectedArray = {course1.getCourseCode()};
        List<String> expectedListArray = Arrays.asList(expectedArray);

        assertEquals(expectedListArray, actual);
    }

    @Test
    void TestInfoMethodAndConsequentiallyAllTheGetters() {
        String actualInfo = teacher.info();

        String expectedInfo = "Name: Prince\n"
                + "Gender: Male\n"
                + "Age: 30\n"
                + "Contact: 09078453724\n"
                + "Address: No. 6 Asajon way\n"
                + "Job title: Teacher\n"
                + "Courses taught: []";

        assertEquals(expectedInfo, actualInfo);
    }
}