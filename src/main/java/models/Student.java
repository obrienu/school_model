package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private long matricNumber;
    private long gradeId;
    private LocalDate admissionDate = LocalDate.now();
    private List<String> courses = new ArrayList<>();

    public Student() {}

    public Student(String firstName, String lastName, String address, String sex, int age, long matricNumber, long gradeId) {
        super(firstName, lastName, address, sex, age);
        this.matricNumber = matricNumber;
        this.gradeId = gradeId;
    }

    public Student(Applicant applicant, long gradeId, long matricNumber) {
        this(applicant.getFirstName(), applicant.getLastName(), applicant.getAddress(), applicant.getSex(), applicant.getAge(), matricNumber, gradeId);
    }

    public long getMatricNumber() {
        return matricNumber;
    }

    public void setMatricNumber(long matricNumber) {
        this.matricNumber = matricNumber;
    }

    public long getGradeId() {
        return gradeId;
    }

    public void setGradeId(long gradeId) {
        this.gradeId = gradeId;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void takeCourse(String courseCode) {

    if(School.getCourse(courseCode) != null){
        this.courses.add(courseCode);
        return;
    }

            System.out.println("Invalid Course input");
    }

    public List<Course> getCourses() {
        List<Course> courseList = new ArrayList<>();
        for(String courseCode: courses){
            courseList.add(School.getCourse(courseCode));
        }
        return courseList;
    }

    public  void dropCourse(String courseCode) {
        if(this.courses.lastIndexOf(courseCode) == -1){
            System.out.println(getFirstName() + " does not take this course");
        }else{
            this.courses.remove(courseCode);
        }
        return;
    }


}