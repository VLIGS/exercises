package factory;

public interface Creator {

    Product factoryMethod();
    /**default Product factoryMethod(){
        return new ConcreteProduct();
    }
     **/
}
