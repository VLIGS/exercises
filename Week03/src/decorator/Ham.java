package decorator;

public class Ham extends PizzaDecorator{
    Pizza myPizza;
    private String myTopping;
    double addOn = 18.12;
    public Ham(Pizza pizza){
        myPizza = pizza;
        myTopping = "Ham";
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
