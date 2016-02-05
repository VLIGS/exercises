package abstractfactory;

public class NYCErrorXMLParser extends ErrorXMLParser{
    public String parse(){
        System.out.println(super.parse());
        return "NYC error in order XML Message";
    }
}
