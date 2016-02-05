package abstractfactory;

public class NYCOrder implements XMLParser{
    public String parse(){
        System.out.println("NYC Parsing order XML...");
        return "NYC Order XML Message";
    }
}
