package models;

import utils.Sex;

public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private Sex sex;
    private int age;

    public  Person() {}

    public Person(String firstName,String lastName, String address, String sex, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        if("M".equals(sex.toUpperCase()) || "MALE".equals(sex.toUpperCase())) {
            this.sex = Sex.MALE;
        } else if ("F".equals(sex.toUpperCase()) || "FEMALE".equals(sex.toUpperCase())) {
            this.sex = Sex.FEMALE;
        } else {
            System.out.println("Invalid sex");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return String.valueOf(sex);
    }

    public void setSex(String sex) {
        if("M".equals(sex.toUpperCase())) {
            this.sex = Sex.MALE;
        } else if ("F".equals(sex.toUpperCase())) {
            this.sex = Sex.FEMALE;
        } else {
            System.out.println("Invalid sex");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "firstName='" + firstName + "\n" +
                "lastName='" + lastName + "\n" +
                "address='" + address + "\n" +
                "sex=" + sex +  "\n" +
                "age=" + age ;
    }
}
