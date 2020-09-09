package entities.machines;

import com.sun.org.apache.xpath.internal.operations.Bool;
import entities.camera.Camera;
import entities.camera.CameraBack;
import entities.camera.Dimensions;

import java.util.Random;
import java.util.UUID;

public class Tester extends Machine {

    private boolean dimensionsCheck;

    public Tester(UUID id, String name) {
        super(id, name);
    }

    public boolean checkDimensions(CameraBack cameraBack) {
        Dimensions standardBack = new Dimensions(25, 20, 15);
        return cameraBack.getDimensions().compareTo(standardBack) > 0;
    }

    public boolean checkAutofocus(Camera camera) {
        Boolean isDefected = new Random().nextInt(10) == 0;
        return !isDefected;
    }

    public void setDimensionsCheck(boolean dimensionsCheck) {
        this.dimensionsCheck = dimensionsCheck;
    }

    @Override
    public String toString() {
        return "Test machine id: " + getId() + "\nName: " + getName();
    }

}
