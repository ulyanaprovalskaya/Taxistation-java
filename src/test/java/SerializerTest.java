import cars.Car;
import cars.ElectricCar;
import cars.PetrolCar;
import taxistation.TaxiStation;
import serialization.Serializer;
import org.junit.Test;

import static org.junit.Assert.*;

public class SerializerTest {

    private Serializer<TaxiStation> serializer = new Serializer<>(TaxiStation.class, new Class[]{Car.class, PetrolCar.class, ElectricCar.class});
    private static final String filepath = "src/test/java/serializationTest.xml";
    private static TaxiStation actualValue;

    private static final String model = "Renault Logan";
    private static final int price = 560;
    private static final int enginePower = 105;
    private static final int maxSpeed = 150;
    private static final double accelerationTime = 6.7;

    @Test
    public void deserialize() {
        actualValue = new TaxiStation();
        serializer.deserialize(actualValue, filepath);
        for(Car car : actualValue.getCars()){
            assertEquals(car.getModel(), model);
            assertEquals(car.getMaxSpeed(), maxSpeed);
            assertEquals(car.getEnginePower(), enginePower);
            assertEquals(car.getPrice(), price, 0.001);
            assertEquals(car.getAccelerationTime(), accelerationTime, 0.001);
        }

    }
}