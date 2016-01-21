package factory;

import java.util.Properties;

public class ConcreteCreator implements Creator{

    private static ConcreteCreator instance = null;  //static constructor block
    private Product myProduct;
    private Properties props = null;

    private ConcreteCreator(){
        props = new Properties();
        
    }

    @Override
    public Product factoryMethod(){
        return null;
    }
}
