package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course phy110;
    String code;
    int creditLoad;
    String title;
    String description;

    @BeforeEach
    void setUp() {
        code = "Phy112";
        creditLoad = 3;
        title = "Wave Principals";
        description = "An Introduction to Electromagnetic Induction";
    }

    @Test
    @DisplayName("Test Course class Constructors and Getters")
    void testConstructorAndGetter() {
        phy110 = new Course(code, creditLoad, title, description);
        assertAll(
                () -> assertEquals(code, phy110.getCode(), "Test should return a correct course code"),
                () -> assertEquals(title, phy110.getTitle(), "Test should return a correct course title"),
                () -> assertEquals(description, phy110.getDescription(), "Test should return a correct course description"),
                () -> assertEquals(creditLoad, phy110.getCreditLoad(), "Test should return a correct course credit load")
                );
    }

    @Test
    @DisplayName("Test Course class setters")
    void testSetters() {
        phy110 = new Course();
        phy110.setCode(code);
        phy110.setCreditLoad(creditLoad);
        phy110.setDescription(description);
        phy110.setTitle(title);

        assertAll(
                () -> assertEquals(code, phy110.getCode(), "Test should return a correct course code"),
                () -> assertEquals(title, phy110.getTitle(), "Test should return a correct course title"),
                () -> assertEquals(description, phy110.getDescription(), "Test should return a correct course description"),
                () -> assertEquals(creditLoad, phy110.getCreditLoad(), "Test should return a correct course credit load")
        );
    }

    @Test
    @DisplayName("Test Course class getCourseSummary method")
    void getCourseSummary() {
        phy110 = new Course(code, creditLoad, title, description);
        String expected = "Course code: Phy112, Title: Wave Principals, Credit load: 3";
        assertEquals(expected, phy110.getCourseSummary(), "Test should return a correct course summary");
    }
}