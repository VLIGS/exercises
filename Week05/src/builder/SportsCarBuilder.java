package builder;

public class SportsCarBuilder implements CarBuilder{
    Car myCar;
    public SportsCarBuilder(){
        myCar = new Car("SPORTS");
    }
    @Override
    public Car getCar(){
        return null;
    }
}
