package connection.cars;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import connection.comparator.PowerComparator;

import java.util.*;

@XStreamAlias("taxiStation")
public class TaxiStation {
    //@XStreamImplicit
    private List<Car> cars;

    public List<Car> getCars() { return cars; }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public TaxiStation(){
        cars = new ArrayList<Car>();
    }

    public int getCost()
    {
        int cost = 0;
        for(Car car : cars){
            cost += car.getPrice();
        }
        return cost;
    }

    public ArrayList<Car> getCarsByGivenProperties(int maxSpeed, double accelerationTime){
        ArrayList<Car> suitableCars = new ArrayList<Car>();

        for(Car car : cars){
            if(car.getMaxSpeed() >= maxSpeed && car.getAccelerationTime() <= accelerationTime){
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public void sort(){
        cars.sort(new PowerComparator());
    }
}
