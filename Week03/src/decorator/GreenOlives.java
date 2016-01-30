package decorator;

public class GreenOlives implements Pizza {
    Pizza myPizza;
    private String myTopping;
    double addOn = 5.47;
    public GreenOlives(Pizza pizza){
        myPizza = pizza;
        myTopping = "GreenOlives";
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
