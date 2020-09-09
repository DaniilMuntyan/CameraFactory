package services;

import entities.camera.Camera;
import entities.machines.Packer;

// Модификатор доступа отсутствует. Для того чтобы сервис был доступен только в классах текущего пакета
final class PackingService {

    public void pack(Packer packer, Camera camera) {
        Boolean isPackedSuccessful = packer.pack(camera);

        if(!isPackedSuccessful) {
            System.out.println("Packer " + packer.getId() + " cannot pack camera " + camera.getId() +
                    " beacause it was rejected");
            return;
        }

        System.out.println("Packer " + packer.getId() + " has been packed a camera " + camera.getId());
    }

}
