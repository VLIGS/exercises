package decorator;

public class GreenOlives implements Pizza {
    private String description;

    public GreenOlives(Pizza pizza) {
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
