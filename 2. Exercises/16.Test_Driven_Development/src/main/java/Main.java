public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World!");

        Car car = new Car("Ferrari", 600);
        Car car1 = new Car("Mazda", 700);
        Car car2 = new Car("Lamborghini", 700);

        Garage garage = new Garage();
        garage.parkCar(car, car1, car2);

        for (Car currentCar : garage) {
            System.out.println(currentCar);
        }
    }
}
