package entities.employees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.UUID;

public final class Manager extends Employee {

    private final Queue<String> defect_queue = new ArrayDeque<>();

    public void orderDetails(String detail) {
        defect_queue.remove(detail);
    }

    public void addToOrder(String detail) {
        defect_queue.add(detail);
    }

    public Manager(String name, String surname) {
        super(name, surname);
    }

    private String getDefectQueue() {
        String detailsToOrder = "";
        for (String detail: defect_queue) {
            detailsToOrder = detailsToOrder.concat(detail + "\n");
        }
        return detailsToOrder;
    }

    @Override
    public String toString() {
        return "Manager id: " + getId() + "\n" + getName() + " " + getSurname() + "\nPhone number: " + getPhone() +
                "\nDetails to order:\n" + getDefectQueue();
    }

}
