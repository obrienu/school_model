package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GradeTest {
    School school;
    Principal principal;
    Grade grade1;
    Student student1, student2;

    @BeforeEach
    void setUp() {
        School.clearLists();
        //the setup instantiates a school, sets a principal who create a grade  and  admits applicant into that grade
        school = new School("Decagon");
        principal = school.employPrincipal("firstName", "lastName", "address", "M", 100, 3243555l);
        grade1 = principal.createGrade(132455454L, "grade1");
        Applicant applicant1 = new Applicant("firstName", "lastName", "hello", "F", 23, 322334L);
        Applicant applicant2 = new Applicant("firstName", "lastName", "hello", "F", 23, 233234L);
        student1 = principal.admitApplicant(applicant1, 234453434, grade1.getId());
        student2 =  principal.admitApplicant(applicant2, 234453345, grade1.getId());
    }



    @Test
    @DisplayName("Test Grade class getters and setters")
    void testGetters() {
        String name = "Year 1";
        long id = 2323L;
        Grade year1 = new Grade(name, id);

        assertAll(
                ()-> assertEquals(name, year1.getName(), "Test should return the name of the grade"),
                ()-> assertEquals(id, year1.getId(), "Test should return the id of the grade")
        );
    }

    @Test
    @DisplayName("Test Grade class getters and setters")
    void testSetters() {
        String name = "Year 1";
        long id = 2323L;
        Grade year1 = new Grade();
        year1.setId(id);
        year1.setName(name);

        assertAll(
                ()-> assertEquals(name, year1.getName(), "Test should set the name of the grade"),
                ()-> assertEquals(id, year1.getId(), "Test should set the id of the grade")
        );


    }

    @Test
    @DisplayName("Test for getClassMember method and addMember method")
    void getClassMembersAndAddMember() {
        List<Student> expected = new ArrayList<>();
        expected.add(student1);
        expected.add(student2);
        assertAll(
                ()-> assertIterableEquals(expected, grade1.getClassMembers(), "Test should return a list of the students added")
        );
    }

}