package decorator;

public class Meat extends PizzaDecorator{
    Pizza myPizza;
    private String myTopping;
    double addOn = 14.25;
    public Meat(Pizza pizza){
        myPizza = pizza;
        myTopping = "Meat";
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
