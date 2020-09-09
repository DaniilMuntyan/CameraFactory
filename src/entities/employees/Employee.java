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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
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

    @Override
    public String toString() {
        return "Employee id: " + id + "\n" + this.name + " " + this.surname + "\nPhone number: " + this.phone;
    }
}
