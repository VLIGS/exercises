package abstractfactory;

//This is abstract factory class
public class ParserFactoryProducer {
    public static AbstractParserFactory getFactory(String factoryName){
        if(factoryName.equals("NYCFactory")) {
            return new NYCFactory();
        }
        else if (factoryName.equals("LondonFactory")){
            return new LondonFactory();
        }
        return null;
    }
}
