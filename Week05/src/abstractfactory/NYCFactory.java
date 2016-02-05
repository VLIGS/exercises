package abstractfactory;

public class NYCFactory implements AbstractParserFactory{
    public XMLParser getParserInstance(String parserType){
        if(parserType.equals("NYCORDER")){
            return new NYCOrderXMLParser();
        }
        else if(parserType.equals("NYCERROR")){
            return new NYCErrorXMLParser();
        }
        else if(parserType.equals("NYCFEEDBACK")){
            return new NYCFeedbackXML();
        }
        else if(parserType.equals("NYCRESPONSES")){
            return new NYCResponseXMLParser();
        }
        return null;
    }
}
