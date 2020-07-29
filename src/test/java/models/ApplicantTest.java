package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicantTest {

    Applicant applicant;
    String firstName;
    String lastName;
    String address;
    String sex;
    int age;
    long id;


    @BeforeEach
    void setUp() {
        firstName = "Obrien";
        lastName = "Longe";
        address = "Decagon Uno";
        age = 100;
        sex = "M";
        id = 23243443334L;
    }

    @Test
    @DisplayName("Test Applicant class Constructor and getter")
    void testConstructorAndGetters() {
        applicant = new Applicant(firstName, lastName, address, sex, age, id);
        assertAll(
                () -> assertEquals(age, applicant.getAge(), "Test should return a correct age"),
                () -> assertEquals(firstName, applicant.getFirstName(), "Test should return a correct firstName"),
                () -> assertEquals(lastName, applicant.getLastName(), "Test should return a correct  lastName"),
                () -> assertEquals("MALE", applicant.getSex(), "Test should return a correct  sex"),
                () -> assertEquals(address, applicant.getAddress(), "Test should return a correct address"),
                () -> assertEquals(id, applicant.getId(), "Test should return a correct address")
        );
    }

    @Test
    @DisplayName("Test Applicant class setters")
    void testSetters(){
        applicant = new Applicant();
        applicant.setAddress(address);
        applicant.setAge(age);
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setSex(sex);
        applicant.setId(id);

        assertAll(
                () -> assertEquals(age, applicant.getAge(), "Test should return a correct age"),
                () -> assertEquals(firstName, applicant.getFirstName(), "Test should return a correct firstName"),
                () -> assertEquals(lastName, applicant.getLastName(), "Test should return a correct  lastName"),
                () -> assertEquals("MALE", applicant.getSex(), "Test should return a correct  sex"),
                () -> assertEquals(address, applicant.getAddress(), "Test should return a correct address"),
                () -> assertEquals(id, applicant.getId(), "Test should return a correct address")
        );
    }
}