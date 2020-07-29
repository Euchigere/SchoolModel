import model.Applicant;
import model.Grade;
import model.Principal;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrincipalTest {
    Principal principal;

    @BeforeEach
    void setUp() {
        principal = new Principal("Chika", "m", 40,
                "08060342565", "No. 6 Asajon way", "Principal");
    }

    @Test
    void admitAplicantWithValidAgeTest() {
        Applicant applicant = new Applicant("Emelda", "f", 13, "07067975643",
                "No. 6 Asajon Way", Grade.CLASS_2.toString());
        boolean isAdmitted = principal.admit(applicant, 16, 10);
        assertTrue(isAdmitted, "The applicant should be admitted");
    }

    @Test
    void admitApplicantWithInvalidAgeTest() {
        Applicant applicant = new Applicant("Josh", "m", 20, "07067975643",
                "No. 6 Asajon Way", Grade.CLASS_2.toString());

        boolean isAdmitted = principal.admit(applicant, 16, 10);
        assertFalse(isAdmitted, "The applicant should not be admitted");
    }

    @Test
    void expelStudentTest() {
        Student student = new Student("Solomon", "m", 14, "07089675436",
                "No. 6 Asajon Way", Grade.CLASS_3.toString(), "0001");
        Student[] studentArray = {student};
        List<Student> studentListArray = new ArrayList<>(Arrays.asList(studentArray));

        principal.expelStudent(studentListArray, "0001");

        assertTrue(studentListArray.size() == 0);
    }
}