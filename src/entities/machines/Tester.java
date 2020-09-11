package entities.machines;

import com.sun.org.apache.xpath.internal.operations.Bool;
import entities.camera.Camera;
import entities.camera.CameraBack;
import entities.camera.Dimensions;

import java.util.Random;
import java.util.UUID;

public final class Tester extends Machine {

    public Tester(String name) {
        super(name);
    }

    public boolean checkDimensions(CameraBack cameraBack) {
        Dimensions standardBack = new Dimensions(25, 20, 15);
        return cameraBack.getDimensions().compareTo(standardBack) > 0;
    }

    public boolean checkAutofocus(Camera camera) {
        Boolean isDefected = new Random().nextInt(4) == 0; // Вероятность дефекта - 1/4
        return !isDefected;
    }

    @Override
    public String toString() {
        return "Test machine id: " + getId() + "\nName: " + getName();
    }

}
