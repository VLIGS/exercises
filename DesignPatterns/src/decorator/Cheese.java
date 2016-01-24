package decorator;

public class Cheese extends PizzaDecorator{
    Pizza myPizza;
    private String myTopping;
    double addOn = 20.72;
    public Cheese(Pizza pizza){
        myPizza = pizza;
        myTopping = "Cheese";
    }
    @Override
    public String getDesc() {
        return myPizza.getDesc() + " " + myTopping + " (" + addOn + ")";
    }

    @Override
    public double getPrice() {
        return myPizza.getPrice() + addOn;
    }
}
