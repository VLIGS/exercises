package decorator;

public class SimplyNonVegPizza implements Pizza {
    private String description;
    private double cost;

    public SimplyNonVegPizza(){
        description = "SimplyNonVegPizza";
        cost = 350.0;
    }
    @Override
    public String getDesc() {
        return description + "(" + cost + ")";
    }

    @Override
    public double getPrice() {
        return cost;
    }
}
