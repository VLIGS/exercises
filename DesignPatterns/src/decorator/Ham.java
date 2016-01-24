package decorator;

public class Ham extends PizzaDecorator{
    Pizza myPizza;
    public Ham(Pizza pizza){
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
