package bridge;

public class BigWheel implements Car{
    Product product;
    String name;
    public BigWheel(Product product, String s){
        this.product = product;
        name = s;
    }
    public void produceProduct(){
        product.produce(name);
    }
    public void assemble(){
        product.assemble(name);
    }
    public void printDetails(){
      System.out.println("Car: " + name + ", Product: " + product.getProductType());
    }
}
