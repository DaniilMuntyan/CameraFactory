package entities.employees;

import entities.camera.*;

public final class Collector extends Employee {

    public Camera assemble(CameraBack cameraBack, CameraBody cameraBody, Lens lens) {
        // System.out.println("Collector " + getName() + " " + getSurname() + " assembled new camera " + camera.getId());
        Employee t = new Employee("", "");
        return new Camera(cameraBack, cameraBody, lens);
    }

    public CameraBack assemble(Dimensions backDims, Long resolution, Long colorDepth) {
        return new CameraBack(backDims, resolution, colorDepth);
    }

    public CameraBody assemble(Dimensions dimensions, String color) {
        return new CameraBody(dimensions, color);
    }

    public Lens assemble(Double focalLength, LensType lensType) {
        return new Lens(focalLength, lensType);
    }

    public void reportDefect(Manager manager, String detail) {
        manager.addToOrder(detail);
    }

    public Collector(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return "Collector id: " + getId() + "\n" + getName() + " " + getSurname() + "\nPhone number: " + getPhone();
    }
}
