package factory;

public abstract class Creator {
    //Factory method, responsibility for creating actual concrete product is delegated to subclass
    public abstract Product returnProduct();
}
