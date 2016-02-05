package abstractfactory;

public class LondonERROR implements XMLParser{
    public String parse(){
        System.out.println("London Parsing error in order XML...");
        return "London error in order XML Message";
    }
}
