package services;

import entities.camera.Camera;
import entities.camera.CameraBack;
import entities.machines.Calibrator;

import java.io.FileWriter;
import java.io.IOException;

public final class CalibrationService {

    public void checkMatrix(Calibrator calibrator, CameraBack cameraBack) {
        Boolean matrixCheck = calibrator.checkMatrix(cameraBack);
        String resultChecking;

        cameraBack.setMatrixCheck(matrixCheck);

        if (matrixCheck)
            resultChecking = "Matrix is serviceable";
        else
            resultChecking = "Matrix is defective";

        System.out.println("Calibrator " + calibrator.getName() + " has checked camera back " + cameraBack.getId() +
                " matrix. " + resultChecking);
    }

    public void innerCharacteristics(Calibrator calibrator, Camera camera) {
        String innerInfo = calibrator.innerCharacteristics(camera);

        camera.setInnerInfo(innerInfo);

        System.out.println("Calibrator " + calibrator.getName() + " has got color characteristics of camera " +
                camera.getId() + ": " + camera.getInnerInfo());
    }

    public void saveResults(Camera camera) {
        try {
            FileWriter csvWriter = new FileWriter("calibration_results.csv");
            String toWrite = camera.getId() + "," + camera.getBack().getMatrixCheck().toString() + "," +
                    camera.getInnerInfo() + "\n";

            csvWriter.append(toWrite);
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.out.println("Results saving failed");
        }

    }

}
