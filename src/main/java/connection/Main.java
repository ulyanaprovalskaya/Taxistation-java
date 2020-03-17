package connection;

import connection.serialization.*;
import connection.cars.*;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Serializer<TaxiStation> serializer = new Serializer<TaxiStation>(TaxiStation.class, new Class[]{Car.class, PetrolCar.class, ElectricCar.class});
        TaxiStation taxiStation = new TaxiStation();
        serializer.deserialize(taxiStation, "taxiStation.xml");

        System.out.println("Стоимость автопарка: " + taxiStation.getCost());
        taxiStation.sort();
        System.out.println("Автомобили таксопарка, отсортированные по мощности двигателя: " + taxiStation.getCars().toString());

        System.out.println("Для поиска автомобилей по параметрам скорости, введите максимальную скорость:");
        Scanner scan = new Scanner(System.in);
        int maxSpeed = scan.nextInt();
        System.out.println("И желаемое время разгона до 100 км/ч:");
        double accelerationTime = scan.nextDouble();
        System.out.println(taxiStation.getCarsByGivenProperties(maxSpeed, accelerationTime).toString());
    }
}
