package Vehicles.entities;

public class Truck extends Vehicle {

    private static final double ADDITIONAL_FUEL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_FUEL_CONSUMPTION, tankCapacity);
    }

}
