package connection.comparator;

import connection.cars.Car;
import java.util.Comparator;

public class PowerComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        if(c1.getEnginePower() > c2.getEnginePower()){
            return 1;
        }
        if(c1.getEnginePower() == c2.getEnginePower()){
            return 0;
        }
        else{
            return -1;
        }
    }
}
