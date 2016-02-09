package builder;

public class SedanCarBuilder implements CarBuilder{
    Car myCar;
    public SedanCarBuilder(){
        myCar = new Car("SEDAN");
    }

    @Override
    public Car getCar(){
        return myCar;
    }
}
