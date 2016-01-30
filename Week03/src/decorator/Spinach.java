package decorator;

public class Spinach extends PizzaDecorator{
    Pizza myPizza;
    private String myTopping;
    double addOn = 7.92;
    public Spinach(Pizza pizza){
        myPizza = pizza;
        myTopping = "Spinach";
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
