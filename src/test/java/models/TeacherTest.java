package models;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    //Variables for creation of teacher
    String schoolName;
    String firstName;
    String lastName;
    String address;
    String sex;
    int age;
    long id;

    //variable for course creation
    String code;
    int creditLoad;
    String title;
    String description;

    School school;
    Principal principal;
    Teacher teacher;
    Course chm112;
    Course phy112;


    @AfterEach
    public void restoreInitialStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);

    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
        School.clearLists();
        schoolName = "Decagon";
        firstName = "Obrien";
        lastName = "Longe";
        address = "Decagon Uno";
        sex = "M";
        age = 100;
        id = 1344244;

        code = "Phy112";
        creditLoad = 3;
        title = "Wave Principals";
        description = "An Introduction to Electromagnetic Induction";

        school = new School(schoolName);
        principal = school.employPrincipal(firstName, lastName, address, sex, age, 234332);
        phy112 = principal.createCourse(code, creditLoad, title, description);
        chm112 =  principal.createCourse("Chem112", 3, "Organic Chemistry", "An intro to orgnaic chem");
        teacher = principal.employTeacher(firstName, lastName, address, sex, age, id);

    }

    @Test
    @DisplayName("Test takeCourse method for Teacher class")
    void takeCoursesWithValidCourseCode() {
        teacher.takeCourse("Phy112");
        int expected  = 1;
        int actual = teacher.getCourses().size();
        assertEquals(actual, expected, "Should return the correct answer for write code input");
    }

    @Test
    @DisplayName("Test takeCourse method for Teacher class with wrong code")
    void takeCoursesWithInvalidCourseCode() {
        teacher.takeCourse("Thgd 112");//wrong course id
        int expected  = 0;
        int actual = teacher.getCourses().size();
        assertAll(
                () -> assertEquals(actual, expected, "Should not add course that is not part of school curriculum"),
                () -> assertEquals("Invalid Course input\n", out.toString(), "Should output right warning for wrong course code input")
        );
    }

    @Test
    @DisplayName("Test getCourse method for Teacher class")
    void getCourse() {
        teacher.takeCourse("Phy112");
        teacher.takeCourse("Chem112");
        List<Course> expected = new ArrayList<>();
        expected.add(phy112);
        expected.add(chm112);
        List<Course> actual = teacher.getCourses();
        assertIterableEquals(expected, actual, "Should return correct answer for wrong code input");
    }

    @Test
    void dropCourse() {
        teacher.takeCourse("Chem112");
       teacher.dropCourse(code);
       int expected = 1;
       int actual = teacher.getCourses().size();
        assertEquals(actual, expected, "Should return the correct number of course teacher is taking");
    }

    @Test
    void testTeachWithRightCode() {
        teacher.takeCourse("Phy112");
        teacher.takeCourse("Chem112");
        teacher.teach(code);
        String actual = out.toString();
        String expected = "Teaching Wave Principals\n";
        assertEquals(expected, actual, "Should return the correct number of course teacher is taking");

    }

    @Test
    void testTeachWithWrongCode() {
        teacher.teach("HTT201");
        String actual = out.toString();
        String expected = "I do not take this subject\n";
        assertEquals(expected, actual, "Should return the correct number of course teacher is taking");

    }
}