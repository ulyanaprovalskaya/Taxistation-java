package test;

import connection.cars.Car;
import connection.cars.ElectricCar;
import connection.cars.PetrolCar;
import connection.cars.TaxiStation;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TaxiStationTest {

    private static TaxiStation taxiStation;

    @BeforeClass
    public static void initializeInstance(){
        taxiStation = new TaxiStation();
        ElectricCar electricCar = new ElectricCar();
        electricCar.setPrice(560);
        electricCar.setEnginePower(105);
        electricCar.setMaxSpeed(150);
        electricCar.setAccelerationTime(6.8);

        PetrolCar petrolCar1 = new PetrolCar();
        petrolCar1.setPrice(1040);
        petrolCar1.setEnginePower(96);
        petrolCar1.setMaxSpeed(210);
        petrolCar1.setAccelerationTime(5.7);

        PetrolCar petrolCar2 = new PetrolCar();
        petrolCar2.setPrice(800);
        petrolCar2.setEnginePower(146);
        petrolCar2.setMaxSpeed(180);
        petrolCar2.setAccelerationTime(6.0);

        List<Car> cars = new ArrayList<Car>();
        cars.add(electricCar);
        cars.add(petrolCar1);
        cars.add(petrolCar2);
        taxiStation.setCars(cars);
    }

    @Test
    public void getCost() {
        assertEquals(2400, taxiStation.getCost());
    }

    @Test
    public void getCarsByGivenProperties() {
        int maxSpeed = 160;
        double accelerationTime = 6.5;

        List<Car> suitableCars = taxiStation.getCarsByGivenProperties(maxSpeed, accelerationTime);

        for(Car car : suitableCars){
            assertTrue(car.getMaxSpeed() >= maxSpeed && car.getAccelerationTime() <= accelerationTime);
        }
    }

    @Test
    public void sort() {
        List<Integer> powers = new ArrayList<Integer>();
        List<Integer> sortedPowers = new ArrayList<Integer>();

        for(Car car : taxiStation.getCars()){
            powers.add(car.getEnginePower());
        }
        Collections.sort(powers);

        taxiStation.sort();

        for(Car car : taxiStation.getCars()){
            sortedPowers.add(car.getEnginePower());
        }

        assertEquals(powers, sortedPowers);
    }
}