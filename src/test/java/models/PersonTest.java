package models;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    Person person;
    String firstName;
    String lastName;
    String address;
    String sex;
    int age;

    @BeforeEach
    void inti() {
        firstName = "Obrien";
        lastName = "Longe";
        address = "Decagon Uno";
        age = 100;
        sex = "M";
    }

    @Test
    @DisplayName("Test Person class Constructor and getters")
    void TestConstructor() {
        person = new Person(firstName, lastName, address, sex, age);
        assertAll(
                () -> assertEquals(age, person.getAge(), "Test should return a correct age"),
                () -> assertEquals(firstName, person.getFirstName(), "Test should return a correct firstName"),
                () -> assertEquals(lastName, person.getLastName(), "Test should return a correct  lastName"),
                () -> assertEquals("MALE", person.getSex(), "Test should return a correct  sex"),
                () -> assertEquals(address, person.getAddress(), "Test should return a correct address")
                );
    }

    @Test
    @DisplayName("Test Person class setters")
    void TestSetters () {
        person = new Person();
        person.setAddress(address);
        person.setAge(age);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setSex(sex);

        assertAll(
                () -> assertEquals(age, person.getAge(), "Check getAge getter and instantiated age"),
                () -> assertEquals(firstName, person.getFirstName(), "Check the getFirstName getter and instantiated firstName"),
                () -> assertEquals(lastName, person.getLastName(), "Check the getlastName getter and instantiated lastName"),
                () -> assertEquals("MALE", person.getSex(), "Check the getlastSexgetter and instantiated sex"),
                () -> assertEquals(address, person.getAddress(), "Check the getAddress getter and instantiated address")
                );
    }

}

