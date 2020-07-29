package models;

import java.time.LocalDate;

public class Applicant extends Person {
    private long id;
    private LocalDate applicationDate = LocalDate.now();

    public Applicant(){}

    public Applicant(String firstName, String lastName, String address, String sex, int age, long id) {
        super(firstName, lastName, address, sex, age);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

}