import cars.*;
import serialization.Serializer;
import taxistation.TaxiStation;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Serializer<TaxiStation> serializer = new Serializer<TaxiStation>(TaxiStation.class, new Class[]{Car.class, PetrolCar.class, ElectricCar.class});
        TaxiStation taxiStation = new TaxiStation();
        serializer.deserialize(taxiStation, "taxiStation.xml");

        System.out.println("Стоимость автопарка: " + taxiStation.getCost());
        taxiStation.sortByEnginePower();
        System.out.println("Автомобили таксопарка, отсортированные по мощности двигателя: " + taxiStation.getCars().toString());

        System.out.println("Для поиска автомобилей по параметрам скорости, введите максимальную скорость:");
        Scanner scan = new Scanner(System.in);
        int maxSpeed = scan.nextInt();
        System.out.println("И желаемое время разгона до 100 км/ч:");
        double accelerationTime = scan.nextDouble();
        List<Car> suitableCars = taxiStation.getCarsByGivenProperties(maxSpeed, accelerationTime);
        if(suitableCars.isEmpty()) System.out.println("Не найдено машин по заданным параметрам");
        else System.out.println(suitableCars.toString());
    }
}
