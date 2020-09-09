package services;

import entities.employees.Collector;
import entities.employees.Manager;

public final class OrderService {

    public void orderDetail(Manager manager, String detail) {
        manager.orderDetails(detail);
        System.out.println("Manager " + manager.getName() + " has ordered " + detail);
    }

}
