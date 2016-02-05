package abstractfactory;

public class LondonFactory implements AbstractParserFactory{
    public XMLParser getParserInstance(String parserType){
        if(parserType.equals("LondonFEEDBACK")){
            return new LondonFEEDBACK();
        }
        else if(parserType.equals("LondonOrder")){
            return new LondonOrder();
        }
        else if(parserType.equals("LondonERROR")){
            return new LondonERROR();
        }
        else if(parserType.equals("LondonRESPONSES")){
            return new LondonRESPONSES();
        }
        return null;
    }

}
