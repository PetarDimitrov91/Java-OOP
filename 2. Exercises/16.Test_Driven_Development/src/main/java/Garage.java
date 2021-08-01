import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Garage implements Iterable<Car> {
    List<Car> cars;

    public Garage() {
        this.cars = new ArrayList<>();
    }

    public void parkCar(Car... car) {
        this.cars.addAll(Arrays.asList(car));
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < cars.size();
            }

            @Override
            public Car next() {
                return cars.get(index++);
            }
        };
    }
}
