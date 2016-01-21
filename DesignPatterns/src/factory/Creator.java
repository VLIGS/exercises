package factory;

public interface Creator {

    Product returnProduct();
    /**default Product returnProduct(){
        return new ConcreteProduct();
    }
     **/
}
