package services;

import com.sun.org.apache.xpath.internal.operations.Bool;
import entities.camera.Camera;
import entities.employees.Technician;
import entities.machines.Tester;

public final class MechanicalTestService {

    public void checkDimensions(Tester tester, Camera camera) {
        Boolean dimensionsCheck = tester.checkDimensions(camera.getBack());

        if(!dimensionsCheck) {
            camera.setRejected();
        }

        String checkingResult = dimensionsCheck ? "success" : "fail";
        System.out.println("Tester " + tester.getName() + " has checked dimensions of camera " + camera.getId() +
                ": " + checkingResult);
    }

    public void checkAutoFocus(Tester tester, Camera camera) {
        Boolean autoFocusCheck = tester.checkAutofocus(camera);

        if (!autoFocusCheck) {
            camera.setRejected();
        }

        String checkingResult = autoFocusCheck ? "success" : "fail";
        System.out.println("Tester " + tester.getName() + " has checked autofocus of camera " + camera.getId() +
                ": " + checkingResult);
    }

    public void checkAudioSystem(Technician technician, Camera camera) {
        Boolean audioCheck = technician.checkAudioSystem(camera);

        if(!audioCheck) {
            camera.setRejected();
        }

        String checkingResult = audioCheck ? "success" : "fail";
        System.out.println("Technician " + technician.getName() + " " + technician.getSurname() + " has checked " +
                "audio system of camera " + camera.getId() + ": " + checkingResult);
    }

}
