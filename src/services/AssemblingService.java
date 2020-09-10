package services;

import entities.camera.*;
import entities.employees.Collector;

public final class AssemblingService {

    public CameraBack assembleBack(Collector collector, Dimensions backDims, Integer resolution, Integer colorDepth) {
        CameraBack cameraBack = collector.assemble(backDims, resolution, colorDepth);
        System.out.println("Collector " + collector.getName() + " " + collector.getSurname() + " has assembled " +
                "camera back " + cameraBack.getId());
        return cameraBack;
    }

    public CameraBody assembleBody(Collector collector, Dimensions dimensions, String color) {
        CameraBody cameraBody = collector.assemble(dimensions, color);
        System.out.println("Collector " + collector.getName() + " " + collector.getSurname() + " has assembled " +
                "camera body " + cameraBody.getId());
        return cameraBody;
    }

    public CameraBody assembleBody(Collector collector, String color) {
        CameraBody cameraBody = collector.assemble(color);
        System.out.println("Collector " + collector.getName() + " " + collector.getSurname() + " has assembled " +
                "camera body " + cameraBody.getId());
        return cameraBody;
    }

    public CameraLens assembleLens(Collector collector, Integer focalLength, LensType lensType) {
        CameraLens cameraLens = collector.assemble(focalLength, lensType);
        System.out.println("Collector " + collector.getName() + " " + collector.getSurname() + " has assembled " +
                "camera lens " + cameraLens.getId());
        return cameraLens;
    }

    public Camera assembleCamera(Collector collector, CameraBack cameraBack, CameraBody cameraBody, CameraLens cameraLens) {
        Camera camera = collector.assemble(cameraBack, cameraBody, cameraLens);
        System.out.println("Collector " + collector.getName() + " " + collector.getSurname() + " has assembled " +
                "camera " + camera.getId());
        return camera;
    }

}
