package abstractfactory;

public class LondonResponseXMLParser extends ResponseXMLParser{
    public String parse(){
        System.out.println(super.parse());
        return "London Responses XML Message";
    }
}
