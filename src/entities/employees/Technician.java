package entities.employees;

import entities.camera.Camera;

import java.util.Random;
import java.util.UUID;

public final class Technician extends Employee {

    public Technician(String name, String surname) {
        super(name, surname);
    }

    public Technician(String name, String surname, String phone) {
        super(name, surname, phone);
    }

    public boolean checkAudioSystem(Camera camera) {
        Boolean isDefected = new Random().nextInt(15) == 0; // Вероятноть дефекта 1/15
        return !isDefected;
    }

    public void flash(Camera camera) {
        camera.setFirmware();
    }

    public void clean(Camera camera) {
        camera.setWipedClean();
    }

    public void reject(Camera camera) {
        camera.setRejected();
    }

    @Override
    public String toString() {
        return "Technician " + getName() + " " + getSurname() + "\nID: " +  getId() + "\nPhone number: " + getPhone();
    }

}
