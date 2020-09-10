package entities.employees;

import entities.camera.*;

public final class Collector extends Employee {

    public Camera assemble(CameraBack cameraBack, CameraBody cameraBody, CameraLens lens) {
        return new Camera(cameraBack, cameraBody, lens);
    }

    public CameraBack assemble(Dimensions backDims, Integer resolution, Integer colorDepth) {
        return new CameraBack(backDims, resolution, colorDepth);
    }

    public CameraBody assemble(Dimensions dimensions, String color) {
        return new CameraBody(dimensions, color);
    }

    public CameraBody assemble(String color) {
        return new CameraBody(color);
    }

    public CameraLens assemble(Integer focalLength, LensType lensType) {
        return new CameraLens(focalLength, lensType);
    }

    public Collector(String name, String surname) {
        super(name, surname);
    }

    public Collector(String name, String surname, String phone) {
        super(name, surname, phone);
    }

    @Override
    public String toString() {
        return "Collector " +  getName() + " " + getSurname() + "\nID: " +  getId() + "\nPhone number: " + getPhone();
    }
}
