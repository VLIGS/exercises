package abstractfactory;

public class NYCFeedbackXML extends FeedbackXMLParser{
    public String parse(){
        System.out.println(super.parse());
        return "NYC Feedback XML Message";
    }
}
