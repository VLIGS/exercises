package abstractfactory;

public class LondonOrder implements XMLParser{
    public String parse(){
        System.out.println("London Parsing order XML...");
        return "London Order XML Message";
    }
}
