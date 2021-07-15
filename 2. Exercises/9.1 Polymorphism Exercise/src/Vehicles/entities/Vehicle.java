package Vehicles.entities;

import Vehicles.Interfaces.Driveable;
import Vehicles.Interfaces.Refuelable;

import java.text.DecimalFormat;

public abstract class Vehicle implements Refuelable, Driveable {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    @Override
    public void drive(double kilometers) {
        if (kilometers * getFuelConsumption() > getFuelQuantity()) {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        } else {
            double fuelNeeded = kilometers * getFuelConsumption();
            setFuelQuantity(getFuelQuantity() - fuelNeeded);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println(this.getClass().getSimpleName() + " travelled " + decimalFormat.format(kilometers) + " km");
        }
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        String clazzName = getClass().getSimpleName();

        if (clazzName.equals("Car") || clazzName.equals("Bus")) {
            if (tankCapacity < getFuelQuantity() + liters) {
                printForTank();
                return;
            }
            setFuelQuantity(getFuelQuantity() + liters);

        } else {
            if (tankCapacity < getFuelQuantity() + (liters * 0.95)) {
                printForTank();
                return;
            }
            setFuelQuantity(getFuelQuantity() + (liters * 0.95));
        }
    }

    private void printForTank() {
        System.out.println("Cannot fit fuel in tank");
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
