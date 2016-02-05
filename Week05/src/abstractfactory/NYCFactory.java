package abstractfactory;

public class NYCFactory implements AbstractParserFactory{
    public XMLParser getParserInstance(String parserType){
        if(parserType.equals("NYCORDER")){
            return new NYCOrder();
        }
        else if(parserType.equals("NYCERROR")){
            return new NYCERROR();
        }
        else if(parserType.equals("NYCFEEDBACK")){
            return new NYCFEEDBACK();
        }
        else if(parserType.equals("NYCRESPONSES")){
            return new NYCRESPONSES();
        }
        return null;
    }
}
