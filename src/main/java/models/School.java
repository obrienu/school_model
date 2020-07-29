package models;

import java.util.HashMap;
import java.util.Map;

public class School {
    private static Map<String, Course> coursesList = new HashMap<>();
    private static Map<Long, Staff> staffList = new HashMap<>();
    private static Map<Long, Student> studentList = new HashMap<>();
    private static Map<Long, Grade> gradeList = new HashMap<>();
    protected static final int MIN_AGE = 18;
    protected static final  int MAX_AGE = 40;
    private String name;

    public School(String name){
        this.name = name;
    }

    public static Map<String, Course> getCoursesList() {
        return coursesList;
    }

    public static Course getCourse(String courseCode) {
        Course course;
        return coursesList.get(courseCode);
    }

    public static void addCourse(Course course) {
        if(coursesList.get(course.getCode()) == null) {
            coursesList.put(course.getCode(), course);
        }else {
            System.out.println("Course with Course code: " + course.getCode() + " already exists");
        }
    }

    public static void removeCourse(String  courseCode) {
        coursesList.remove(courseCode);
    }



    public static Map<Long, Staff> getStaffList() {
        return staffList;
    }

    public static Staff getStaff(long staffId) {
        Staff staff;
        return staffList.get(staffId);
    }

    public static void addStaff(Staff staff) {
        if(staffList.get(staff.getId()) == null){
            staffList.put(staff.getId(), staff);
        }else {
            System.out.println("A staff with Id: " + staff.getId() + " already exists");
        }
    }

    public static void removeStaff(long staffId) {
        staffList.remove(staffId);
    }

    public static Map<Long, Student> getStudentList() {
        return studentList;
    }

    public static Student getStudent(long matricNumber) {
        return studentList.get(matricNumber);
    }

    public static void addStudent(Student student) {
        if (studentList.get(student.getMatricNumber()) == null) {
            studentList.put(student.getMatricNumber(), student);
        } else {
            System.out.println("Student with this matric number already exists");
        }
    }

    public static void removeStudent(long matricNumber) {
        if (studentList.get(matricNumber) == null) {
            System.out.println("Student with this matric number does not exists");
        } else {
            studentList.remove(matricNumber);
        }
    }

    public static Map<Long, Grade> getGradeList() {
        return gradeList;
    }

    public static Grade getGrade(long id) {
        return gradeList.get(id);
    }

    public static void addGrade(Grade grade) {
        if(gradeList.get(grade.getId()) == null) {
            gradeList.put(grade.getId(), grade);
        } else {
            System.out.println("A grade with this id already exists");
        }
    }

    public static void removeGrade(long id){
        gradeList.remove(id);
    }

    public static  void clearLists() {
        staffList.clear();
        studentList.clear();
        gradeList.clear();
        coursesList.clear();
    }


    public Principal employPrincipal(String firstName, String lastName, String address, String sex, int age, long id) {
        Principal principal = new Principal(firstName, lastName, address, sex, age, id);
        staffList.put(id, principal);
        return principal;
    }

    public void sackPrincipal(long id) {
        if(getStaffList().get(id) == null || !(staffList.get(id) instanceof Principal)){
            System.out.println("Enter correct id");
            return;
        }
        staffList.remove(id);
    }


}
