package entities.employees;

import entities.camera.Camera;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.UUID;

public final class Manager extends Employee {

    private final Queue<Camera> defect_queue;

    public void orderDetailsFor(Camera camera) {
        defect_queue.remove(camera);
    }

    public void addToOrder(Camera camera) {
        defect_queue.add(camera);
    }

    public Manager(String name, String surname) {
        super(name, surname);
        defect_queue = new ArrayDeque<>();
    }

    public Manager(String name, String surname, String phone) {
        super(name, surname, phone);
        defect_queue = new ArrayDeque<>();
    }

    private String getDefectQueue() {
        String detailsToOrder = "";
        for (Camera camera: defect_queue) {
            detailsToOrder = detailsToOrder.concat(camera.getId() + "\n");
        }
        return detailsToOrder;
    }

    @Override
    public String toString() {
        return "Manager " + getName() + " " + getSurname() + "\nID: " +  getId() + "\nPhone number: " + getPhone() +
                "\nDetails to order: " + getDefectQueue();
    }

}
