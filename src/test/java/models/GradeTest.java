package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeTest {



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
    void getClassMembers() {

    }

    @Test
    void addMember() {
    }
}