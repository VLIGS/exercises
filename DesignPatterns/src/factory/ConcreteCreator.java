package factory;

import java.io.FileInputStream;
import java.util.Properties;

public class ConcreteCreator extends Creator{

    private static ConcreteCreator instance = null;  //static constructor block
    private Product myProduct;
    private Properties props = null;

    private ConcreteCreator(){
        props = new Properties();
        try {
            props.load(new FileInputStream("/Users/lulu/IdeaProjects/exercises/DesignPatterns/src/factory/bean.properties"));

            // get the implementation class
            String productClass = props.getProperty("product.class");
            // get product type
            String productType = props.getProperty("product.type");
            myProduct = (Product) Class.forName(productClass).newInstance();
            myProduct.setProductName(productType);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static {
        instance = new ConcreteCreator(); //static constructor block, when class is used, this will run,
        //this is use of singlton design pattern
    }

    public static ConcreteCreator getInstance() {
        return instance;
    }

    @Override
    public Product returnProduct(){
        return myProduct;
    }
}
