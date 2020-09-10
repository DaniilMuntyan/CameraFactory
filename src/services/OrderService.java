package services;

import entities.camera.Camera;
import entities.employees.Collector;
import entities.employees.Manager;

public final class OrderService {

    public void reportAboutDefect(Manager manager, Camera camera) {
        manager.addToOrder(camera);
        System.out.println("Defect of camera (" + camera.getId() + ") has been reported to manager" +
                manager.getName() + " " + manager.getSurname());
    }

    public void orderDetails(Manager manager, Camera camera) {
        manager.orderDetailsFor(camera);
        System.out.println("Manager " + manager.getName() + " " + manager.getSurname() +
                " has ordered details for camera " + camera.getId());
    }

}
