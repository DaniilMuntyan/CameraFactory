package entities.camera;

import java.util.UUID;

public final class Camera {

    private final UUID id;
    private String innerInfo;
    private Boolean isPacked = false;
    private Boolean isFirmware = false;
    private Boolean isWipedClean = false;
    private Boolean isRejected = false;
    private CameraBack back;
    private CameraBody cameraBody;
    private CameraLens lens;

    public Camera() {
        this.id = UUID.randomUUID();
    }

    public Camera(CameraBack back, CameraBody cameraBody, CameraLens lens) {
        this.back = back;
        this.cameraBody = cameraBody;
        this.lens = lens;
        this.id = UUID.randomUUID();
    }

    public void setPacked() {
        this.isPacked = true;
    }

    public void setFirmware() {
        this.isFirmware = true;
    }

    public void setWipedClean() {
        this.isWipedClean = true;
    }

    public void setRejected() {
        this.isRejected = true;
    }

    public Boolean getRejected() {
        return isRejected;
    }

    public UUID getId() {
        return id;
    }

    public CameraBack getBack() {
        return back;
    }

    public String getInnerInfo() {
        return innerInfo;
    }

    public void setInnerInfo(String innerInfo) {
        this.innerInfo = innerInfo;
    }

    @Override
    public String toString() {
        String packing = isPacked ? "Packed" : "Unpacked";
        String flashing = isFirmware ? "flashed" : "unflashed";
        String cleaning = isWipedClean ? "wiped" : "not wiped";

        String string = (packing + ", "  + cleaning + ", " +  flashing + " camera " + id + "\n" + back + "\n" +
                cameraBody + "\n" + lens);
        return string;
    }
}
