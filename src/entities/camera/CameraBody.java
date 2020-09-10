package entities.camera;

import java.util.Random;
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

    public CameraBody(String color) {
        Random rand = new Random();
        this.dimensions = new Dimensions(15 + rand.nextInt(5), 15 + rand.nextInt(15),
                15 + rand.nextInt(5));
        this.color = color;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Camera body id: " + id + "cm\nDimensions: " + dimensions + "\nColor: " + color;
    }

    public UUID getId() {
        return id;
    }

}
