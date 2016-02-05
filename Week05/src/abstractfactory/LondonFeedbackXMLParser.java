package abstractfactory;

public class LondonFeedbackXMLParser extends FeedbackXMLParser{
    public String parse(){
        System.out.println(super.parse());
        return "London Feedback XML Message";
    }
}
