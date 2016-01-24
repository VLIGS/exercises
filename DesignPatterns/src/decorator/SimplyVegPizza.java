package decorator;

public class SimplyVegPizza implements Pizza{
    private String description;
    private double cost;
    public SimplyVegPizza(){
        description = "SimplyVegPizza";
        cost = 230.0;
    }
    public String getDesc(){
        return description + "(" + cost + ")";
    }
    public double getPrice(){
        return cost;
    }
}
