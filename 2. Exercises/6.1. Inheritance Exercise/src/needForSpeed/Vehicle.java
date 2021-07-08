package needForSpeed;

public class Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
        this.setFuel(fuel);
        this.setHorsePower(horsePower);
    }

 //  public static double getDefaultFuelConsumption() {
 //      return DEFAULT_FUEL_CONSUMPTION;
 //  }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
        double neededFuel = kilometers * this.fuelConsumption;
        if(neededFuel<= this.fuel){
            this.fuel -= neededFuel;
        }
    }
}
