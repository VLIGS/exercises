package abstractfactory;

public class LondonFactory implements AbstractParserFactory{
    public XMLParser getParserInstance(String parserType){
        if(parserType.equals("LondonFEEDBACK")){
            return new LondonFeedbackXMLParser();
        }
        else if(parserType.equals("LondonOrder")){
            return new LondonOrderXMLParser();
        }
        else if(parserType.equals("LondonERROR")){
            return new LondonErrorXMLParser();
        }
        else if(parserType.equals("LondonRESPONSES")){
            return new LondonResponseXMLParser();
        }
        return null;
    }

}
