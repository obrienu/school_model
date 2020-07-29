package models;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Staff{
    private List<String> courses = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String address, String sex, int age, long id) {
        super(firstName, lastName, address, sex, age, id);
    }

    public List<Course> getCourses() {
        List<Course> courseList = new ArrayList<>();
        for(String courseCode: courses){
            courseList.add(School.getCourse(courseCode));
        }
        return courseList;
    }

    public void takeCourse(String courseCode){

            if(School.getCourse(courseCode) != null){
                this.courses.add(courseCode);
                return;
            }

            System.out.println("Invalid Course input");

    }

    public void dropCourse( String courseCode){
            if(this.courses.indexOf(courseCode) == -1){
                System.out.println(getFirstName() + " does not teach this course");
            }else{
                this.courses.remove(courseCode);
            }
        return;
    }

    public void teach(String courseCode) {

        if(courses.indexOf(courseCode) == -1) {
            System.out.println("I do not take this subject");
            return;
        }


        if ( School.getCourse(courseCode) != null) {
                System.out.println("Teaching " + School.getCourse(courseCode).getTitle());
                return;
        }

    }
}
