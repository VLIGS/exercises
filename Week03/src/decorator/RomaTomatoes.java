package decorator;

public class RomaTomatoes implements Pizza {
    Pizza myPizza;
    private String myTopping;
    double addOn = 5.20;
    public RomaTomatoes(Pizza pizza){
        myPizza = pizza;
        myTopping = "RomaTomatoes";
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
