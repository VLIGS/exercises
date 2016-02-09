package bridge;

public class GearLocking implements Product {
    private String productType;
    public GearLocking(String productType) {
        this.productType = productType;
    }
    @Override
    public void produce(String s) {
        System.out.println("Producing " + productType);

        System.out.println("Modifying product " + productType + " according to " + s);

    }
    @Override
    public void assemble(String s) {

        System.out.println("Assembling " + productType + " for " + s);

    }

    @Override
    public String getProductType(){
        return productType;
    }
}
