package Vehicles.entities;

public class Car extends Vehicle {

    private static final double ADDITIONAL_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_FUEL_CONSUMPTION, tankCapacity);
    }

}
