package entities.camera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public final class CameraLens {

    private final UUID id;
    private final Integer focalLength;
    private final LensType lensType;

    public CameraLens(Integer focalLength, LensType lensType) {
        this.focalLength = focalLength;
        this.lensType = lensType;
        this.id = UUID.randomUUID();
    }

    public CameraLens() {
        Random rand = new Random();
        LensType[] lensTypeLength = LensType.values();

        this.focalLength = 35 + rand.nextInt(35);
        this.lensType = lensTypeLength[rand.nextInt(lensTypeLength.length)];
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Camera lens id: " + id + "\n" + "Focal length: " + focalLength + " mm\nLens type: " + lensType;
    }

    public UUID getId() {
        return id;
    }

}
