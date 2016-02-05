package abstractfactory;

public class NYCRESPONSES implements XMLParser{
    public String parse(){
        System.out.println("NYC Parsing responses XML...");
        return "NYC Responses XML Message";
    }
}
