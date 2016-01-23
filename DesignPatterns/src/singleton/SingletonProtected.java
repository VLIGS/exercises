package singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonProtected implements Serializable {

    //constant
    private static final long serialVersionUID = -1093810940935189395L;
    //eager initialisation, object instantiated only once
    private static SingletonProtected instance = new SingletonProtected();

    //private constructor, makes sure object instantiated only once
    //this also resolves problem of breaking singleton pattern using reflection
    private SingletonProtected() {
        if (instance != null) {
            throw new IllegalStateException("Already created.");
        }
    }

    //this is solution to the problem of using multiple class loaders
    //by specifying class loader here, ensure same class loader loads singleton
    private static Class getClass(String classname) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null)
            classLoader = SingletonProtected.class.getClassLoader();
        return (classLoader.loadClass(classname));
    }

    //this will return same instance of a singleton
    public static SingletonProtected getInstance() {
        return instance;
    }

    //this should solve the problem of singleton implementing Serializable interface
    //this overrides the instance read from the stream
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

    private Object writeReplace() throws ObjectStreamException {
        return instance;
    }

    //this solves the problem of extending/implementing from class
    //which implements Clonable interface, allowing to clone singleton
    //by overriding this method make sure singleton can not be cloned
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton, cannot be cloned");
    }

}