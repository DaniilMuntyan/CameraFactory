package entities.camera;

import java.util.UUID;

public final class CameraBody {

    private final UUID id;
    private final Dimensions dimensions;
    private final String color;

    public CameraBody(Dimensions dimensions, String color) {
        this.dimensions = dimensions;
        this.color = color;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Camera body id: " + id + "\nDimensions: " + dimensions + "\nColor: " + color;
    }

    public UUID getId() {
        return id;
    }

}
