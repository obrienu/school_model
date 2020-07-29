package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student;
    String firstName;
    String lastName;
    String address;
    String sex;
    int age;
    long matricNumber;
    long gradeId;
    Course phy112 ;
    Course chm112;


    @BeforeEach
    void setUp() {
        firstName = "Obrien";
        lastName = "Longe";
        address = "Decagon Uno";
        age = 100;
        sex = "M";
        matricNumber = 23243443334L;
        gradeId = 3243L;

         phy112 = new Course("Phy112", 3, "Wave and Optics", "Intro to wave and optics");
        chm112 = new Course("Chm112", 3, "Organic Chem", "Intro to wave and optics");

    }

    @Test
    @DisplayName("Test Student class constructor and setter")
    void testConstrictorAndGetters() {
        student = new Student(firstName, lastName, address, sex, age, matricNumber, gradeId);
        assertAll(
                () -> assertEquals(age, student.getAge(), "Check getAge getter and instantiated age"),
                () -> assertEquals(firstName, student.getFirstName(), "Check the getFirstName getter and instantiated firstName"),
                () -> assertEquals(lastName, student.getLastName(), "Check the getlastName getter and instantiated lastName"),
                () -> assertEquals("MALE", student.getSex(), "Check the getlastSexgetter and instantiated sex"),
                () -> assertEquals(address, student.getAddress(), "Check the getAddress getter and instantiated address"),
                () -> assertEquals(matricNumber, student.getMatricNumber(), "Check the getMAtricNumber getter and instantiated matricNumber"),
                () -> assertEquals(gradeId, student.getGradeId(), "Check the getGradeId getter and instantiated address")
        );
    }

    @Test
    @DisplayName("Test Student Class setters")
    void testSetters() {
        student = new Student();
        student.setGradeId(gradeId);
        student.setMatricNumber(matricNumber);
        student.setAddress(address);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setSex(sex);
        student.setAge(age);

        assertAll(
                () -> assertEquals(age, student.getAge(), "Check getAge getter and instantiated age"),
                () -> assertEquals(firstName, student.getFirstName(), "Check the getFirstName getter and instantiated firstName"),
                () -> assertEquals(lastName, student.getLastName(), "Check the getlastName getter and instantiated lastName"),
                () -> assertEquals("MALE", student.getSex(), "Check the getlastSexgetter and instantiated sex"),
                () -> assertEquals(address, student.getAddress(), "Check the getAddress getter and instantiated address"),
                () -> assertEquals(matricNumber, student.getMatricNumber(), "Check the getMAtricNumber getter and instantiated matricNumber"),
                () -> assertEquals(gradeId, student.getGradeId(), "Check the getGradeId getter and instantiated address")
        );
    }

    @Test
    @DisplayName("Student class takeCourse, getCourses, and dropCourses method")
    void testSetCourses() {

        ArrayList<Course> expected = new ArrayList<>();
        expected.add(phy112);
        expected.add(chm112);
        School.addCourse(phy112);
        School.addCourse(chm112);
        student = new Student(firstName, lastName, address, sex, age, matricNumber, gradeId);
        student.takeCourse(phy112.getCode());
        student.takeCourse(chm112.getCode());

        assertAll(
                ()-> assertIterableEquals(expected, student.getCourses(), "Test Should return a list of courseCode"),
                ()-> assertEquals(2, student.getCourses().size(), "Test Should return the number of courses offered by student")
        );

        student.dropCourse(chm112.getCode());
        int index = student.getCourses().indexOf(chm112.getCode());

        assertEquals(-1, index, "Test should not contain the dropped course");
        assertEquals(1, student.getCourses().size(), "Test should not contain the dropped course");

    }
}