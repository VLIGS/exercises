package abstractfactory;

public class NYCFactory implements AbstractParserFactory{
    public XMLParser getParserInstance(String parserType){
        if(parserType.equals("NYCORDER")){
            return new NYCOrder();
        }
        return null;
    }
}
