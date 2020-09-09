package entities.camera;

import java.util.UUID;

public final class CameraBack {

    private Boolean matrixCheck;
    private final Dimensions dimensions;
    private final Long resolution;
    private final Long colorDepth;

    private UUID id;

    public CameraBack(Dimensions dimensions, Long resolution, Long colorDepth) {
        this.dimensions = dimensions;
        this.resolution = resolution;
        this.colorDepth = colorDepth;
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
        return "Camera back id: " + id + "\nDimensions: " + dimensions + "\nResolution" + resolution +
                "\nColor depth: " + colorDepth;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public UUID getId() {
        return id;
    }

}
