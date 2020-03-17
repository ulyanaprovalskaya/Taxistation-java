package comparator;

import cars.Car;
import java.util.Comparator;

public class PowerComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        return Integer.compare(c1.getEnginePower(), c2.getEnginePower());
    }
}
