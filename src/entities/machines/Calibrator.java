package entities.machines;

import entities.camera.Camera;
import entities.camera.CameraBack;

import java.util.Random;
import java.util.UUID;

public final class Calibrator extends Machine {

    public Calibrator(String name) {
        super(name);
    }

    public boolean checkMatrix(CameraBack cameraBack) {
        Random rnd = new Random();
        Boolean matrixCheck = rnd.nextInt(10) != 0; // Probability of defect: 1/10
        cameraBack.setMatrixCheck(matrixCheck);
        return matrixCheck;
    }

    public String innerCharacteristics(Camera camera) {
        Random rand = new Random();

        Double lensAngleOfView = 10 + (180 - 10) * rand.nextDouble();
        Double lensSpeed = 0 + 11 * rand.nextDouble();
        Double depthOfField = 2 + 18 * rand.nextDouble();

        String colorInfo = "Lens angle of view: " + lensAngleOfView.toString() + "\nLens speed: " +
                lensSpeed.toString() + "\nDepth of field: " + depthOfField.toString();
        return colorInfo;
    }

    @Override
    public String toString() {
        return "Calibration machine id: " + getId() + "\nName: " + getName();
    }
}
