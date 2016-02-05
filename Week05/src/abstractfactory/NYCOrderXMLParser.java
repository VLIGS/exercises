package abstractfactory;

public class NYCOrderXMLParser extends OrderXMLParser{
    public String parse(){
        System.out.println(super.parse());
        return "NYC Order XML Message";
    }
}
