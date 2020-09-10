package entities.camera;

import java.util.Random;
import java.util.UUID;

public final class CameraBack {

    private Boolean matrixCheck;
    private final Dimensions dimensions;
    private final Integer resolution;
    private final Integer colorDepth;

    private UUID id;

    public CameraBack(Dimensions dimensions, Integer resolution, Integer colorDepth) {
        this.dimensions = dimensions;
        this.resolution = resolution;
        this.colorDepth = colorDepth;
        this.id = UUID.randomUUID();
    }

    public CameraBack() {
        Random rand = new Random();
        this.dimensions = new Dimensions(8 + rand.nextInt(2), 6 + rand.nextInt(4),
                4 + rand.nextInt(2));
        this.resolution = 20 + rand.nextInt(60); // Мпикс
        this.colorDepth = 10 + rand.nextInt(7); // Биты
        this.id = UUID.randomUUID();
    }

    public Boolean getMatrixCheck() {
        return matrixCheck;
    }

    public void setMatrixCheck(Boolean matrixCheck) {
        this.matrixCheck = matrixCheck;
    }

    @Override
    public String toString() {
        return "Camera back id: " + id + "\nDimensions: " + dimensions + "\nResolution: " + resolution +
                " MP\nColor depth: " + colorDepth + " bpp";
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public UUID getId() {
        return id;
    }

}
