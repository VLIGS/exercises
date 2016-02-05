package abstractfactory;

public class LondonErrorXMLParser extends ErrorXMLParser{
    public String parse(){
        System.out.println(super.parse());
        return "London error in order XML Message";
    }
}
