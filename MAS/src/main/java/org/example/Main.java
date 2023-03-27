package org.example;

public class Main {
    public static void main(String[] args) {
        ManagerAgent managerAgent = new ManagerAgent();
        Reader reader = new Reader(managerAgent);
        managerAgent.watchOrders();
        managerAgent.writeStatisticsToJson();
    }
}
