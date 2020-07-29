package models;

public class NonAcademicStaff extends Staff{
    public NonAcademicStaff() {
    }

    public NonAcademicStaff(String firstName, String lastName, String address, String sex, int age, long id) {
        super(firstName, lastName, address, sex, age, id);
    }

    public void work() {
        System.out.println("working ........");
    }
}
