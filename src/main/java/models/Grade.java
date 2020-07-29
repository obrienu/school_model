package models;


import java.util.ArrayList;
import java.util.List;

public class Grade {
    private String name;
    private long id;
    private List<Long> classMembers = new ArrayList<>();

    public Grade() {}

    public Grade(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public List<Student> getClassMembers() {
        List<Student> members = new ArrayList<>();
        for(long id: classMembers) {
            members.add(School.getStudentList().get(id));
        }
        return members;
    }

    public void addMember(long id) {
        if(classMembers.indexOf(id) == -1){
            classMembers.add(id);
        }else {
            System.out.println("Student already exists");
        }
        return;
    }

    public void removeMember(long id) {
        classMembers.remove(id);
    }
}
