package abstractfactory;

public class NYCResponseXMLParser extends ResponseXMLParser{
    public String parse(){
        System.out.println(super.parse());
        return "NYC Responses XML Message";
    }
}
