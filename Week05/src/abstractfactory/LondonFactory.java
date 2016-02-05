package abstractfactory;

public class LondonFactory implements AbstractParserFactory{
    public XMLParser getParserInstance(String parserType){
        if(parserType.equals("LondonFEEDBACK")){
            return new NYCOrder();
        }
        return null;
    }

}
