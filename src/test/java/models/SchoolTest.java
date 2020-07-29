package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    School school;
    Principal principal;
    Course course1, course2;
    Grade grade1;
    Student student1, student2;
    Teacher teacher;
    String schoolName;
    String firstName;
    String lastName;
    String address;
    String sex;
    int age;
    long id;

    @BeforeEach
    void init() {
        // Initialisation of app to avoid repetition of code
        School.clearLists();
        schoolName = "Decagon";
        firstName = "Obrien";
        lastName = "Longe";
        address = "Decagon Uno";
        sex = "M";
        age = 100;
        id = 1344244;
        //instantiate a school and create a principal
        school = new School(schoolName);
        principal = school.employPrincipal(firstName, lastName, address, sex, age, id);
        //principal creates a grade
        grade1 = principal.createGrade(132455454L, "grade1");
        //principal creates two courses
        course1 = principal.createCourse("Phy112", 2, "Hello", "Hello world");
        course2 = principal.createCourse("Phy113", 4, "Physics", "Hello world Physics");
        //creates 2 applicants
        Applicant applicant1 = new Applicant("firstName", "lastName", "hello", "F", 23, 322334L);
        Applicant applicant2 = new Applicant("firstName", "lastName", "hello", "F", 23, 233234L);
        // Principal admits a student into the school and add student to school list and student grade/class
        student1 = principal.admitApplicant(applicant1, 234453434, grade1.getId());
        student2 =  principal.admitApplicant(applicant2, 234453345, grade1.getId());
        //Principal employs a teacher
        teacher = principal.employTeacher("Longe", "James", "hello ", "M", 34, 23243);

    }

    @Test
    @DisplayName("Test employ Principal method in School class")
    void employPrincipal() {
        //sack the previous principal to remove him from the list;
        school.sackPrincipal(principal.getId());
        Principal newPrincipal = school.employPrincipal("Chigozie", "Okafor", "ddfg egge", "M", 50, 4344534);
        assertEquals(newPrincipal, School.getStaff(newPrincipal.getId()), "Test should check if a principal was employed");
    }

    @Test
    @DisplayName("Test sackPrincipal method in School class")
    void sackPrincipalWithWrongId() {
        int expected = 1;
        school.sackPrincipal(principal.getId());
        int actual = School.getStaffList().size();
        assertEquals(expected, actual, "Test checks if pricipal is sacke when wrong id is provided");
    }

    @Test
    @DisplayName("Test getCourseList method")
    void getCoursesList() {
        Map<String, Course> expected = new HashMap<>();
        expected.put(course1.getCode(), course1);
        expected.put(course2.getCode(), course2);

        assertEquals(expected, School.getCoursesList(), "Method Should return a correct list of courses");
    }

    @Test
    void testGetCourseMethod() {
        assertEquals(course1, School.getCourse(course1.getCode()), "Method should return the course with the course code passed to it");
    }

    @Test
    void testaddCourseMethod() {
        Course course3 = new Course("Phy122", 5, "Chemistry", "Hello orgaic");
        School.addCourse(course3);
        int expected = 3;
        int actual = School.getCoursesList().size();
        assertEquals(expected, actual, "Method should add a new course to the course list");

        School.addCourse(course3);
        expected = 3;
        actual = School.getCoursesList().size();
        assertEquals(expected, actual, "Method should not add the same course twice");
    }

    @Test
    void testRemoveCourse() {
        School.removeCourse(course1.getCode());
        assertEquals(null, School.getCourse(course1.getCode()), "Method should correctly remove the course from the list of courses");
    }

    @Test
    void getStaffList() {
        Teacher teacher2 = principal.employTeacher("firstName", "lastName", "address", "M", 23, 343334);
        Map<Long, Staff> expected = new HashMap<>();
        expected.put(principal.getId(), principal);
        expected.put(teacher.getId(), teacher);
        expected.put(teacher2.getId(), teacher2);
        assertEquals(expected, School.getStaffList(), "Method should return the correct list of staff created");
    }

    @Test
    void getStaff() {
        Teacher expected = principal.employTeacher("firstName", "lastName", "address", "M", 23, 343334);
        Staff actual = School.getStaff(expected.getId());
        assertEquals(expected, actual, "Method should return the correct Staff with the provided id");
    }

    @Test
    void addStaff() {
        //should return a total of 3 teacher, i.e principal teacher initially created plus the new teacher that would be added

        Teacher teacher2 = principal.employTeacher("firstName", "lastName", "address", "M", 23, 343334);
        School.addStaff(teacher2);
        assertEquals(3, School.getStaffList().size(), "Method should add a new staff the staff list ");
        // test edge case when the same teacher is added twice
        School.addStaff(teacher2);
        assertEquals(3, School.getStaffList().size(), "Method should not add the same teacher twice");
    }

    @Test
    void removeStaff() {
        Teacher teacher2 = principal.employTeacher("firstName", "lastName", "address", "M", 23, 343334);
        School.addStaff(teacher2);
        School.removeStaff(teacher2.getId());
        assertEquals(null, School.getStaff(teacher2.getId()), "Method should remove the staff with the provided code from the staff list");

    }

    @Test
    void getStudentList() {
        Map<Long, Student> expected = new HashMap<>();
        expected.put(student1.getMatricNumber(), student1);
        expected.put(student2.getMatricNumber(), student2);
        assertEquals(expected, School.getStudentList(), "Method Should return a correct list of Students");
    }

    @Test
    void getStudent() {
        assertEquals(student1, School.getStudent(student1.getMatricNumber()), "Method should return the correct student with the id passed to it");
    }

    @Test
    void addStudent() {
        Student student3 = new Student("Hello", "World", "dgdss ffh", "M", 21, 52434322, grade1.getId() );
        School.addStudent(student3);
        assertEquals(student3, School.getStudent(student3.getMatricNumber()), "Method should successfully add new student to student list");
        School.addStudent(student3);
        assertEquals(3, School.getStudentList().size(), "Method should not add a student multiple times");
    }

    @Test
    void removeStudent() {
        Student student3 = new Student("Hello", "World", "dgdss ffh", "M", 21, 52434322, grade1.getId() );
        School.addStudent(student3);
        School.removeStudent(student3.getMatricNumber());
        assertEquals(null, School.getStudent(student3.getMatricNumber()), "Method should successfully remove the student with the id from the students list");
    }

    @Test
    void getGradeList() {
        Grade grade2 = new Grade("grade2", 4343);
        School.addGrade(grade2);
        Map<Long, Grade> expected = new HashMap<>();
        expected.put(grade1.getId(), grade1);
        expected.put(grade2.getId(), grade2);
        assertEquals(expected, School.getGradeList(), "Method Should return a correct list of Grades");
    }

    @Test
    void getGrade() {
        assertEquals(grade1, School.getGrade(grade1.getId()), "Method should return the correct grade for the id passed to it");
    }

    @Test
    void addGrade() {
        Grade grade2 = new Grade("grade2", 4343);
        School.addGrade(grade2);
        assertEquals(grade2, School.getGrade(grade2.getId()), "Method should add the grade the the list of grades");

    }

    @Test
    void removeGrade() {
        Grade grade2 = new Grade("grade2", 4343);
        School.addGrade(grade2);
        School.removeGrade(grade2.getId());
        assertEquals(null, School.getGrade(grade2.getId()), "Method should remove the correct grade with the id from the list of grades");

    }

}