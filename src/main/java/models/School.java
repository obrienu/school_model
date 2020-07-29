package models;

import java.util.HashMap;
import java.util.Map;

public class School {
    //Serves as a database for students, courses, staff and grades/classes
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



    /**
     *
     * @param courseCode
     * @return
     */
    public static Course getCourse(String courseCode) {
        //returns a particular course with the course code provided
        Course course;
        return coursesList.get(courseCode);
    }

    /**
     *
     * @param course
     */
    public static void addCourse(Course course) {
        //adds a course to the course list, prevents duplicate of course code
        if(coursesList.get(course.getCode()) == null) {
            coursesList.put(course.getCode(), course);
        }else {
            System.out.println("Course with Course code: " + course.getCode() + " already exists");
        }
    }

    /**
     *
     * @param courseCode
     */
    public static void removeCourse(String  courseCode) {
        coursesList.remove(courseCode);
    }



    public static Map<Long, Staff> getStaffList() {
        return staffList;
    }

    /**
     *
     * @param staffId
     * @return
     */
    public static Staff getStaff(long staffId) {
        //returns the staff with specified staff id
        return staffList.get(staffId);
    }

    /**
     *
     * @param staff
     */
    public static void addStaff(Staff staff) {
        //checks if a staff with similar id already exists before adding the staff
        if(staffList.get(staff.getId()) == null){
            staffList.put(staff.getId(), staff);
        }else {
            System.out.println("A staff with Id: " + staff.getId() + " already exists");
        }
    }

    /**
     *
     * @param staffId
     */
    public static void removeStaff(long staffId) {
        //removes the specified staff with id
        staffList.remove(staffId);
    }

    public static Map<Long, Student> getStudentList() {
        return studentList;
    }

    /**
     *
     * @param matricNumber
     * @return
     */
    public static Student getStudent(long matricNumber) {
        return studentList.get(matricNumber);
    }

    /**
     *
     * @param student
     */
    public static void addStudent(Student student) {
        //checks if student with the matric number already exists, to prevent multiple entry
        if (studentList.get(student.getMatricNumber()) == null) {
            studentList.put(student.getMatricNumber(), student);
        } else {
            System.out.println("Student with this matric number already exists");
        }
    }

    /**
     *
     * @param matricNumber
     */
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

    /**
     *
     * @param id
     * @return
     */
    public static Grade getGrade(long id) {
        return gradeList.get(id);
    }

    /**
     *
     * @param grade
     */
    public static void addGrade(Grade grade) {
        //checks if grade with same course code already exists
        if(gradeList.get(grade.getId()) == null) {
            gradeList.put(grade.getId(), grade);
        } else {
            System.out.println("A grade with this id already exists");
        }
    }

    /**
     *
     * @param id
     */
    public static void removeGrade(long id){
        gradeList.remove(id);
    }


    public static  void clearLists() {
        staffList.clear();
        studentList.clear();
        gradeList.clear();
        coursesList.clear();
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param sex
     * @param age
     * @param id
     * @return
     */
    public Principal employPrincipal(String firstName, String lastName, String address, String sex, int age, long id) {
        Principal principal = new Principal(firstName, lastName, address, sex, age, id);
        staffList.put(id, principal);
        return principal;
    }

    /**
     *
     * @param id
     */
    public void sackPrincipal(long id) {
        //checks to make sure the id provided is a principals id
        if(getStaffList().get(id) == null || !(staffList.get(id) instanceof Principal)){
            System.out.println("Enter correct id");
            return;
        }
        staffList.remove(id);
    }


}
