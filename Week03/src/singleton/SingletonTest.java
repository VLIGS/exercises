package singleton;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SingletonTest {
    @Test
    public void serialisedTest() throws FileNotFoundException, IOException, ClassNotFoundException {
        SingletonProtected instanceOne = SingletonProtected.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SingletonProtected instanceTwo = (SingletonProtected) in.readObject();
        in.close();

        assertEquals(instanceOne.hashCode(),instanceTwo.hashCode());
    }
    @Test
    public void reflectionTest() {
        SingletonProtected instanceOne = SingletonProtected.getInstance();
        SingletonProtected instanceTwo = null;
            Constructor[] constructors = SingletonProtected.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                try {
                instanceTwo = (SingletonProtected) constructor.newInstance();
                fail("My method didn't throw when I expected it to");
            }catch(Exception e){
            }
        }
    }
}

