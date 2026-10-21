package com.codewithsimo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalManager {
    List<Vehicle> vehicles = new ArrayList<>(
            List.of(new Car("Nissan", 2026),
                    new Car("Ford", 2022),
                    new Car("Mazda", 2016)
            ));
    private Scanner scanner = new Scanner(System.in);
    private boolean hasStarted = true;

    public void start() {
        while (hasStarted) {
            displayMenu();

            int choice = scanner.nextInt();
            System.out.println("choice : " + choice);
            switch (choice) {
                case 1 -> listVehicle();
                case 2 -> addVehicle();
                case 8 -> {
                    hasStarted = false;
                    System.out.println("Existing System. Goodbye");
                }
            }

        }
    }

    private void addVehicle() {
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        Car car = new Car(model, year);
        vehicles.add(car);

    }

    private void listVehicle() {
        vehicles.stream()
                .map(v -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(vehicles.indexOf(v) + 1);
                    sb.append(". ")
                            .append(v.getModel())
                            .append("(")
                            .append(v.getYear())
                            .append(") - ")
                            .append(v.isRented() ? "Rented" : "Available");
                    return sb.toString();
                })
                .forEach(v -> {
                    System.out.println(v);
                });
    }

    private void displayMenu() {
        System.out.println("\n-------------------");
        System.out.println("Vehicle Rental System");
        System.out.println("---------------------");
        System.out.println("1. List Vehicles");
        System.out.println("2. Add vehicles");

        System.out.println("8. Exit");
    }
}
