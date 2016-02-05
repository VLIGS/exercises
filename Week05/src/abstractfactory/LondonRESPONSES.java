package abstractfactory;

public class LondonRESPONSES implements XMLParser{
    public String parse(){
        System.out.println("London Parsing responses XML...");
        return "London Responses XML Message";
    }
}
