package entities.machines;

import entities.camera.Camera;
import entities.camera.CameraBack;

import java.util.Random;
import java.util.UUID;

public class Calibrator extends Machine {

    public Calibrator(UUID id, String name) {
        super(id, name);
    }

    public boolean checkMatrix(CameraBack cameraBack) {
        Random rnd = new Random();
        Boolean matrixCheck = rnd.nextInt(10) != 0;
        cameraBack.setMatrixCheck(matrixCheck);
        return matrixCheck;
    }

    public String innerCharacteristics(Camera camera) {
        Random rand = new Random();
        Double lensAngleOfView = 10 + (180 - 10) * rand.nextDouble(); // Угол поля зрения
        Double lensSpeed = 0 + 11 * rand.nextDouble(); // Светосила
        Double depthOfField = 2 + 18 * rand.nextDouble(); // Глубина резко изображаемого пространства
        String colorInfo = "Lens angle of view: " + lensAngleOfView.toString() + "\nLens speed: " +
                lensSpeed.toString() + "\nDepth of field: " + depthOfField.toString();
        return colorInfo;
    }

    @Override
    public String toString() {
        return "Calibration machine id: " + getId() + "\nName: " + getName();
    }
}
