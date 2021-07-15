package Vehicles;

import Vehicles.entities.Bus;
import Vehicles.entities.Car;
import Vehicles.entities.Truck;
import Vehicles.entities.Vehicle;

import java.util.Scanner;

public class Main {

    static Vehicle car, truck, bus;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String[] carData = console.nextLine().trim().split("\\s+");
        String[] truckData = console.nextLine().trim().split("\\s+");
        String[] busData = console.nextLine().trim().split("\\s+");
        int commandsNumber = Integer.parseInt(console.nextLine());

        car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]), Double.parseDouble(carData[3]));
        truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]), Double.parseDouble(truckData[3]));
        bus = new Bus(Double.parseDouble(busData[1]), Double.parseDouble(busData[2]), Double.parseDouble(busData[3]));

        for (int i = 0; i < commandsNumber; i++) {

            String[] commandData = console.nextLine().trim().split("\\s+");

            String command = commandData[0];
            String vehicleType = commandData[1];
            double kilometersOrLiters = Double.parseDouble(commandData[2]);

            switch (command) {
                case "Drive":
                case "DriveEmpty":
                    drive(vehicleType, kilometersOrLiters, command);
                    break;
                case "Refuel":
                    refuel(vehicleType, kilometersOrLiters);
                    break;
            }

            System.out.println(car);
            System.out.println(truck);
            System.out.println(bus);
        }
    }

    private static void drive(String vehicleType, double kilometersOrLiters, String command) {
        if (isACar(vehicleType)) {
            car.drive(kilometersOrLiters);
        } else if (isATruck(vehicleType)) {
            truck.drive(kilometersOrLiters);
        } else if (isABus(vehicleType)) {
            switch (command) {
                case "DriveEmpty":
                    bus.drive(kilometersOrLiters);
                    break;
                case "Drive":
                    bus.setFuelConsumption(bus.getFuelConsumption() + 1.4);
                    bus.drive(kilometersOrLiters);
                    break;
            }
        }
    }

    private static void refuel(String vehicleType, double liters) {

        if (isACar(vehicleType)) {
            car.refuel(liters);

        } else if (isATruck(vehicleType)) {
            truck.refuel(liters);

        } else if (isABus(vehicleType)) {
            bus.refuel(liters);
        }
    }

    private static boolean isACar(String vehicleType) {
        return vehicleType.equals("Car");
    }

    private static boolean isATruck(String vehicleType) {
        return vehicleType.equals("Truck");
    }

    private static boolean isABus(String vehicleType) {
        return vehicleType.equals("Bus");
    }

}
