package services;

import entities.camera.Camera;
import entities.employees.Technician;
import entities.machines.Packer;

public final class FinalStageService {

    private final PackingService packingService;

    public FinalStageService() {
        packingService = new PackingService();
    }

    public void flash(Technician technician, Camera camera) {
        technician.flash(camera);
        System.out.println("Technician " + technician.getName() + " " + technician.getSurname() + " has flashed " +
                "camera " + camera.getId());
    }

    public void clean(Technician technician, Camera camera) {
        technician.clean(camera);
        System.out.println("Technician " + technician.getName() + " " + technician.getSurname() + " has cleaned " +
                "camera " + camera.getId());
    }

    public void reject(Technician technician, Camera camera) {
        technician.reject(camera);
        System.out.println("Technician " + technician.getName() + " " + technician.getSurname() + " has rejected " +
                "camera " + camera.getId());
    }

    public void packCamera(Packer packer, Camera camera) {
        packingService.pack(packer, camera);
    }

}
