package abstractfactory;

public class NYCErrorXMLParser implements XMLParser{
    public String parse(){
        System.out.println("NYC Parsing error in order XML...");
        return "NYC error in order XML Message";
    }
}
