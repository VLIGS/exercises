package abstractfactory;

public class LondonOrderXMLParser implements XMLParser{
    public String parse(){
        System.out.println("London Parsing order XML...");
        return "London Order XML Message";
    }
}
