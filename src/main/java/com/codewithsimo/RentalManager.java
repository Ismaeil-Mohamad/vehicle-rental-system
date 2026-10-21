package com.codewithsimo;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println("choice : " + choice);
                switch (choice) {
                    case 1 -> listVehicle();
                    case 2 -> addVehicle();
                    case 3 -> updateVehicle();
                    case 4 -> deleteVehicle();
                    case 8 -> {
                        hasStarted = false;
                        System.out.println("Existing System. Goodbye");
                    }
                    default -> System.out.println("Invalid choice");

                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }


        }
    }

    private void deleteVehicle() {
        listVehicle();

        System.out.println("Enter vehicle number to delete:  ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < vehicles.size()) {
            vehicles.remove(index);
        } else {
            System.out.println("Invalid selection");
        }

    }

    private void updateVehicle() {
        listVehicle();
        System.out.println("Enter vehicle number to update:  ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < vehicles.size()) {
            Vehicle vehicle = vehicles.get(index);

            System.out.println("Enter new model: ");
            vehicle.setModel(scanner.nextLine());
            System.out.println("Enter new year: ");
            vehicle.setYear(scanner.nextInt());
            scanner.nextLine();
        } else {
            System.out.println("Invalid selection");
        }


    }

    private void addVehicle() {
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

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
        System.out.println("3. Update vehicles");
        System.out.println("4. Delete vehicles");
        System.out.println("8. Exit...");

    }
}
