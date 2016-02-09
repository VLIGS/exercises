package builder;

public class CarDirector {
    private CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder){
        this.carBuilder = carBuilder;
    }
    public void build(){
        carBuilder.buildBody();
        carBuilder.buildPower();
        carBuilder.buildEngine();
        carBuilder.buildBeaks();
        carBuilder.buildSeats();
        carBuilder.buildWindows();
        carBuilder.buildFuelType();
    }
}
