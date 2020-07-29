package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    School school;
    String schoolName;
    String firstName;
    String lastName;
    String address;
    String sex;
    int age;
    long id;

    @BeforeEach
    void init() {
        schoolName = "Decagon";
        firstName = "Obrien";
        lastName = "Longe";
        address = "Decagon Uno";
        sex = "M";
        age = 100;
        id = 1344244;
        school = new School(schoolName);
        school.employPrincipal(firstName, lastName, address, sex, age, id);
    }

    @Test
    @DisplayName("Test employ Principal method in School class")
    void employPrincipal() {
        int expected = 1;
        int actual = School.getStaffList().size();
        assertEquals(expected, actual, "Test should check if a principal was employed");
    }

    @Test
    @DisplayName("Test sackPrincipal method in School class")
    void sackPrincipal() {
        int expected = 0;
        school.sackPrincipal(id);
        int actual = School.getStaffList().size();
        assertEquals(expected, actual, "Test checks if a principal was sacked");
    }

    @Test
    @DisplayName("Test sackPrincipal method in School class")
    void sackPrincipalWithWrongId() {
        int expected = 1;
        school.sackPrincipal(2322434);
        int actual = School.getStaffList().size();
        assertEquals(expected, actual, "Test checks if pricipal is sacke when wrong id is provided");
    }
}