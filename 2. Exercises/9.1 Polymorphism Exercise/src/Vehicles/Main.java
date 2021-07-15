package Vehicles;

import Vehicles.entities.Bus;
import Vehicles.entities.Car;
import Vehicles.entities.Truck;
import Vehicles.entities.Vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String[] carData = console.nextLine().trim().split("\\s+");
        String[] truckData = console.nextLine().trim().split("\\s+");
        String[]busData = console.nextLine().trim().split("\\s+");
        int commandsNumber = Integer.parseInt(console.nextLine());

        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]), Double.parseDouble(carData[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]), Double.parseDouble(truckData[3]));
        Vehicle bus = new Bus(Double.parseDouble(busData[1]), Double.parseDouble(busData[2]), Double.parseDouble(busData[3]));

        for (int i = 0; i < commandsNumber; i++) {

            String[] commandData = console.nextLine().trim().split("\\s+");

            String command = commandData[0];
            String vehicleType = commandData[1];
            double kilometersOrLiters = Double.parseDouble(commandData[2]);

            switch (command) {
                case "Drive":
                    switch (vehicleType) {
                        case "Car":
                            car.drive(kilometersOrLiters);
                            break;
                        case "Truck":
                            truck.drive(kilometersOrLiters);
                            break;
                        case "Bus":
                            bus.setFuelConsumption(bus.getFuelConsumption() + 1.4);
                            bus.drive(kilometersOrLiters);
                    }
                    break;
                case "Refuel":
                    switch (vehicleType) {
                        case "Car":
                            car.refuel(kilometersOrLiters);
                            break;
                        case "Truck":
                            truck.refuel(kilometersOrLiters);
                            break;
                        case "Bus":
                            bus.refuel(kilometersOrLiters);
                    }
                    break;
                case "DriveEmpty":
                    bus.drive(kilometersOrLiters);
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
