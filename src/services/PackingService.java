package services;

import entities.camera.Camera;
import entities.machines.Packer;

// Модификатор доступа отсутствует. Для того чтобы сервис был доступен только в классах текущего пакета
final class PackingService {

    public void pack(Packer packer, Camera camera) {
        String failed = "Packer " + packer.getName() + " failed to pack camera " + camera.getId() +
                ", beacause it had been rejected";
        String success = "Packer " + packer.getName() + " has packed camera " + camera.getId();

        Boolean isPackedSuccessful = packer.pack(camera);

        String packingResults = isPackedSuccessful ? success : failed;

        System.out.println(packingResults);
    }

}
