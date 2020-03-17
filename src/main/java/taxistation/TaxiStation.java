package taxistation;

import cars.Car;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import comparator.PowerComparator;
import org.apache.log4j.*;

import java.util.*;

@XStreamAlias("taxiStation")
public class TaxiStation {
    private static final Logger logger = LogManager.getLogger(TaxiStation.class);
    private List<Car> cars;

    public List<Car> getCars() { return cars; }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public TaxiStation(){
        cars = new ArrayList<>();
    }

    public int getCost()
    {
        logger.info("Cost of the taxi station was calculated");
        int cost = 0;
        for(Car car : cars){
            cost += car.getPrice();
        }
        return cost;
    }

    public ArrayList<Car> getCarsByGivenProperties(int maxSpeed, double accelerationTime){
        logger.info("Taxi station was searched for speed properties");
        ArrayList<Car> suitableCars = new ArrayList<>();

        for(Car car : cars){
            if(car.getMaxSpeed() >= maxSpeed && car.getAccelerationTime() <= accelerationTime){
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public void sortByEnginePower(){
        cars.sort(new PowerComparator());
        logger.info("Cars were sorted by engine power");
    }
}
