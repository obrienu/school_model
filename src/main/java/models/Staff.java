package models;

import java.time.LocalDate;

abstract  class Staff extends Person{
    private long id;
    private LocalDate dateEmployed = LocalDate.now();

    public Staff() {}

    public Staff(String firstName, String lastName, String address, String sex, int age, long id) {
        super(firstName, lastName, address, sex, age);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateEmployed() {
        return dateEmployed;
    }
}
