package entities.employees;

import java.util.UUID;

public class Employee {

    private final String name;
    private final String surname;
    private final UUID id;
    private String phone;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }

    public Employee(String name, String surname, String phone) {
        this(name, surname);
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public UUID getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Employee " + this.name + " " + this.surname + "\nID: " +  this.id + "\nPhone number: " + this.phone;
    }
}
