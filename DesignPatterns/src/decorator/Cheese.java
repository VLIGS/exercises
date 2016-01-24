package decorator;

public class Cheese extends PizzaDecorator{
    Pizza myPizza;
    public Cheese(Pizza pizza){
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
