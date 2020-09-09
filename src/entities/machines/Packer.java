package entities.machines;

import entities.camera.Camera;

import java.util.UUID;

public class Packer extends Machine {

    public Packer(UUID id, String name) {
        super(id, name);
    }

    public boolean pack(Camera camera) {
        if(camera.getRejected())
            return false;

        camera.setPacked();

        return true;
    }

    @Override
    public String toString() {
        return "Packing machine id: " + getId() + "\nName: " + getName();
    }

}
