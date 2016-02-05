package abstractfactory;

public class LondonOrderXMLParser extends OrderXMLParser{
    public String parse(){
        System.out.println(super.parse());
        return "London Order XML Message";
    }
}
