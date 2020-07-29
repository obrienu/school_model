package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrincipalTest {

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
        //Principal creates grade
        grade1 = principal.createGrade(132455454L, "grade1");
        //creates 2 applicants
        Applicant applicant1 = new Applicant("firstName", "lastName", "hello", "F", 23, 322334L);
        Applicant applicant2 = new Applicant("firstName", "lastName", "hello", "F", 23, 233234L);
        // Principal admits a student into the school and add student to school list and student grade/class
        student1 = principal.admitApplicant(applicant1, 234453434, grade1.getId());
        student2 =  principal.admitApplicant(applicant2, 234453345, grade1.getId());

    }

    @Test
    void expelStudent() {
        principal.expelStudent(student1.getMatricNumber());
        assertEquals(null, School.getStudent(student1.getMatricNumber()), "Method should remove the student from the list of student");
        int actual = School.getGrade(student1.getGradeId()).getClassMembers().indexOf(student1.getMatricNumber());
        assertEquals(-1, actual, "Method should remove student from grade/class list");
    }

    @Test
    void admitApplicant() {
        Applicant applicant3 = new Applicant("Obrien", "James", "hello", "M", 23, 234L);
        Student newStudent = principal.admitApplicant(applicant3, 23444253, grade1.getId());
        assertEquals(newStudent, School.getStudent(newStudent.getMatricNumber()), "Method should admit new student and add student to students list");
    }

    @Test
    void employTeacher() {
        Teacher newTeacher = principal.employTeacher("Okafor", "Odira", "hello ", "M", 34, 3232);
        assertEquals(newTeacher, School.getStaff(newTeacher.getId()), "Method should create teacher and add teacher tot the school list");
        principal.employTeacher("Okafor", "Odira", "hello ", "M", 34, 3232);
        //list should have a size of two, i.e principal and the first teacher created
        assertEquals(2, School.getStudentList().size(), "Method should not add staff with the same id twice");
    }

    @Test
    void sackStaff() {
        Teacher newTeacher = principal.employTeacher("Okafor", "Odira", "hello ", "M", 34, 3232);
        principal.sackStaff(newTeacher.getId());
        assertEquals(null, School.getStaff(newTeacher.getId()), "Method should remove teacher from the staff list");
    }

    @Test
    void createGrade() {
        Grade grade2 = principal.createGrade(1325454L, "grade2");
        assertEquals(grade2, School.getGrade(grade2.getId()), "Method should create grade and add grade to school list");
        //create a new grade with the same id as grade2 earlier created
        Grade grade3 = principal.createGrade(1325454L, "grade3");
        assertEquals(2, School.getGradeList().size(), "Method should not create grade with the same id");

    }

    @Test
    void removeGrade() {
        Grade grade2 = principal.createGrade(1325454L, "grade2");
        principal.removeGrade(grade2.getId());
        assertEquals(null, School.getGrade(grade2.getId()), "Method should remove grade from the school list");
    }

    @Test
    void createCourse() {
        //principal creates two courses
        course1 = principal.createCourse("Phy112", 2, "Hello", "Hello world");
        course2 = principal.createCourse("Phy113", 4, "Physics", "Hello world Physics");
        assertEquals(course1, School.getCourse(course1.getCode()), "Method should create course and add course to list of courses");
        assertEquals(2, School.getCoursesList().size(), "Method should create the appropriate amount of courses");
        //principal creates a new course with same course code as the previous course created
        principal.createCourse("Phy112", 3, "Computer Science", " A simple intro");
        assertEquals(2, School.getCoursesList().size(), "Method should not create courses with same course code");
    }

    @Test
    void deleteCourse() {
        course1 = principal.createCourse("Phy112", 2, "Hello", "Hello world");
        course2 = principal.createCourse("Phy113", 4, "Physics", "Hello world Physics");
        principal.deleteCourse(course1.getCode());
        principal.deleteCourse(course2.getCode());

        assertEquals(null, School.getCourse(course1.getCode()), "Method should delete course list of courses");
        assertEquals(null, School.getCourse(course2.getCode()), "Method should delete course list of courses");
        assertEquals(0, School.getCoursesList().size(), "Method should delete course list of courses");
    }
}