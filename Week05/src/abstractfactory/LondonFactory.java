package abstractfactory;

public class LondonFactory implements AbstractParserFactory{
    public XMLParser getParserInstance(String parserType){
        System.out.print("London ");
        if(parserType.equals("FEEDBACK")){
            return new LondonFeedbackXMLParser();
        }
        else if(parserType.equals("ORDER")){
            return new LondonOrderXMLParser();
        }
        else if(parserType.equals("ERROR")){
            return new LondonErrorXMLParser();
        }
        else if(parserType.equals("RESPONSES")){
            return new LondonResponseXMLParser();
        }
        return null;
    }

}
