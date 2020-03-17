package cars;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("petrolCar")
public class PetrolCar extends Car {
    private double petrolConsumption;
    private double exhaustLevel;

    public double getPetrolConsumption() {
        return petrolConsumption;
    }

    public void setPetrolConsumption(double petrolConsumption) {
        this.petrolConsumption = petrolConsumption;
    }

    public double getExhaustLevel() {
        return exhaustLevel;
    }

    public void setExhaustLevel(double exhaustLevel) {
        this.exhaustLevel = exhaustLevel;
    }

    public PetrolCar(){
        super();
        petrolConsumption = 0;
        exhaustLevel = 0;
    }

    @Override
    public String toString(){
        return super.toString() + ", расход топлива: " + petrolConsumption;
    }
}
