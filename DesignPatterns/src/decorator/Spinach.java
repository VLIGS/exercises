package decorator;

public class Spinach extends PizzaDecorator{
    Pizza myPizza;
    public Spinach(Pizza pizza){
        myPizza = pizza;
    }
    @Override
    public String getDesc() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
