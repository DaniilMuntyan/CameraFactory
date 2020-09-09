package services;

import entities.camera.*;
import entities.employees.Collector;
import entities.employees.Manager;

public final class AssemblingService {

    public void assembleBack(Collector collector, Dimensions backDims, Long resolution, Long colorDepth) {
        CameraBack cameraBack = collector.assemble(backDims, resolution, colorDepth);
        System.out.println("Collector " + collector.getName() + " " + collector.getSurname() + " has assembled " +
                "a digital camera back " + cameraBack.getId());
    }

    public void assembleBody(Collector collector, Dimensions dimensions, String color) {
        CameraBody cameraBody = collector.assemble(dimensions, color);
        System.out.println("Collector " + collector.getName() + " " + collector.getSurname() + " has assembled " +
                "a camera body " + cameraBody.getId());
    }

    public void assembleLens(Collector collector, Double focalLength, LensType lensType) {
        Lens cameraLens = collector.assemble(focalLength, lensType);
        System.out.println("Collector " + collector.getName() + " " + collector.getSurname() + " has assembled " +
                "a camera body " + cameraLens.getId());
    }

    public void assembleCamera(Collector collector, CameraBack cameraBack, CameraBody cameraBody, Lens comeraLens) {
        collector.assemble(cameraBack, cameraBody, comeraLens);
        System.out.println("Collector " + collector.getName() + " " + collector.getSurname() + " has assembled " +
                "a camera lens " + comeraLens.getId());
    }

    public void reportDetailDefect(Collector collector, Manager manager, String detail) {
        collector.reportDefect(manager, detail);
        System.out.println("Collector " + collector.getName() + " " + collector.getSurname() + " has reported to " +
                "manager  " + manager.getName() + " " + manager.getSurname() + " to order " + detail);
    }

}
