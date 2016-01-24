package decorator;

public class Meat extends PizzaDecorator{
    Pizza myPizza;
    public Meat(Pizza pizza){
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
