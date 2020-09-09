package entities.camera;

import java.util.UUID;

public final class Lens {

    private final UUID id;
    private final Double focalLength;
    private final LensType lensType;

    public Lens(Double focalLength, LensType lensType) {
        this.focalLength = focalLength;
        this.lensType = lensType;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Camera lens id: " + id + "\n" + "Focal length: " + focalLength + "\nLens type: " + lensType;
    }

    public UUID getId() {
        return id;
    }

}
