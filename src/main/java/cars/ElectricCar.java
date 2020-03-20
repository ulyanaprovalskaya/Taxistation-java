package cars;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("electricCar")
public class ElectricCar extends Car {
    private int reservePower;
    private int minChargeTime;

    public int getReservePower() {
        return reservePower;
    }

    public void setReservePower(int reservePower) {
        this.reservePower = reservePower;
    }

    public int getMinChargeTime() {
        return minChargeTime;
    }

    public void setMinChargeTime(int minChargeTime) {
        this.minChargeTime = minChargeTime;
    }

    public ElectricCar(){
        super();
        reservePower = 0;
        minChargeTime = 0;
    }

    @Override
    public String toString(){
        return super.toString() + ", запас хода: " + reservePower + ", время зарядки: " + minChargeTime;
    }
}
