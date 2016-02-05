package abstractfactory;

public class NYCFeedbackXML implements XMLParser{
    public String parse(){
        System.out.println("NYC Parsing feedback XML...");
        return "NYC Feedback XML Message";
    }
}
