package abstractfactory;

public class NYCERROR implements XMLParser{
    public String parse(){
        System.out.println("NYC Parsing error in order XML...");
        return "NYC error in order XML Message";
    }
}
