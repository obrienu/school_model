package models;

public class Principal extends Staff {
    public Principal() {
    }

    public Principal(String firstName, String lastName, String address, String sex, int age, long id) {
        super(firstName, lastName, address, sex, age, id);
    }


    public void expelStudent(long matricNumber) {
        Student student = School.getStudent(matricNumber);
        //checks if student with the provided matric number exists in the students list
        if(student != null) {
            School.removeStudent(matricNumber);
            School.getGrade(student.getGradeId()).removeMember(student.getMatricNumber());
            System.out.println(student.getFirstName() + " has been expelled from the school");
        }
    }


    public Student admitApplicant(Applicant applicant, long matricNumber, long gradeId) {
        //checks if applicants meets the acceptance age criteria
        if(applicant.getAge() > School.MAX_AGE){
            System.out.println("Applicant too old to be admitted");
            return null;
        }

        if(applicant.getAge() < School.MIN_AGE){
            System.out.println("Applicant too young to be admitted");
            return null;
        }
        //checks if a student with a similar matric number already exists
        if(School.getStudent(matricNumber) == null) {
            Student newStudent = new Student(applicant, gradeId, matricNumber);
            School.addStudent(newStudent);
            School.getGrade(gradeId).addMember(matricNumber);
            System.out.println(applicant.getFirstName() + " has been admitted to the school");
            return newStudent;
        }
        System.out.println("Student with this matric numnber already exists");
        return null;
    }

    public Teacher employTeacher(String firstName, String lastName, String address, String sex, int age, long id) {
        //checks if teacher with similar staff id exists before creating a new teacher
        if(School.getStaff(id) == null){
            Teacher newTeacher = new Teacher(firstName, lastName, address, sex, age, id);
            School.addStaff(newTeacher);
            return newTeacher;
        }
            System.out.println("Teacher with this id already exists");
            return null;
    }

    public void sackStaff(long staffId) {
            if( School.getStaff(staffId) != null ) {
                School.removeStaff(staffId);
                System.out.println("Staff has been sacked from the school");
                return;
            }
        System.out.println("Invalid staff Id");
    }

    public Grade createGrade(long id, String name) {
        //checks if grade with similar course code exists before creating a new course
        if(School.getGrade(id) == null) {
            Grade newGrade = new Grade();
            newGrade.setName(name);
            newGrade.setId(id);
            School.addGrade(newGrade);
            return newGrade;
        }
        System.out.println("A grade with similar id already exists");
        return null ;
    }

    public void removeGrade(long id) {
        School.removeGrade(id);
    }

    public Course createCourse(String code, int creditLoad, String title, String description) {
        // for duplicate entry of course code
        if(School.getCourse(code) == null){
            Course newCourse= new Course(code,creditLoad,title,description);
            School.addCourse(newCourse);
            return newCourse;
        }
        return null;

    }

    public void deleteCourse(String code) {
        School.removeCourse(code);
    }
}
