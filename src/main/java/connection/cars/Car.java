package connection.cars;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("car")
public class Car {
    private String model;
    private int price;
    private int maxSpeed;
    private double accelerationTime;
    private int enginePower;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAccelerationTime() {
        return accelerationTime;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public void setAccelerationTime(double accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public Car(){
        model = null;
        price = 0;
        maxSpeed = 0;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("\n" + model + "\nМаксимальная скорость: " + maxSpeed + ", время разгона до 10 км/ч: " + accelerationTime);
        return result.toString();
    }
}
