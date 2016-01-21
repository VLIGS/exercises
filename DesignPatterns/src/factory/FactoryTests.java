package factory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactoryTests {
    private Product myProduct;
    private Creator myCreator = ConcreteCreator.getInstance();
    @Before
    public void setUp() throws Exception
    {
        myProduct = myCreator.returnProduct();
    }
    @Test
    public void test1()
    {
        assertEquals("concrete", myProduct.getProductName());
    }
}
