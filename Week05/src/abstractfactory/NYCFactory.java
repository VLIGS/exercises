package abstractfactory;

public class NYCFactory implements AbstractParserFactory{
    public XMLParser getParserInstance(String parserType){
        System.out.print("NYC ");
        if(parserType.equals("ORDER")){
            return new NYCOrderXMLParser();
        }
        else if(parserType.equals("ERROR")){
            return new NYCErrorXMLParser();
        }
        else if(parserType.equals("FEEDBACK")){
            return new NYCFeedbackXML();
        }
        else if(parserType.equals("RESPONSES")){
            return new NYCResponseXMLParser();
        }
        return null;
    }
}
