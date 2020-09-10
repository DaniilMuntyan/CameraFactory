package services;

import entities.camera.Camera;
import entities.machines.Packer;

// Модификатор доступа отсутствует. Для того чтобы сервис был доступен только в классах текущего пакета
final class PackingService {

    public void pack(Packer packer, Camera camera) {
        Boolean isPackedSuccessful = packer.pack(camera);

        if(!isPackedSuccessful) {
            System.out.println("Packer " + packer.getId() + " failed to pack camera " + camera.getId() +
                    " beacause it had been rejected");
            return;
        }

        System.out.println("Packer " + packer.getName() + " has packed camera " + camera.getId());
    }

}
