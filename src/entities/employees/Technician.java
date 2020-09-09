package entities.employees;

import entities.camera.Camera;

import java.util.Random;
import java.util.UUID;

public final class Technician extends Employee {

    public Technician(String name, String surname) {
        super(name, surname);
    }

    public boolean checkAudioSystem(Camera camera) {
        Boolean isDefected = new Random().nextInt(15) == 0;
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
        return "Technician id: " + getId() + "\n" + getName() + " " + getSurname() + "\nPhone number: " + getPhone();
    }

}
