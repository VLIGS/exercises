package abstractfactory;

public class TestAbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractParserFactory parserFactory = ParserFactoryProducer.getFactory("NYCFactory");
        //XMLParser parser = parserFactory.getParserInstance("NYCORDER");
        XMLParser parser = parserFactory.getParserInstance("ORDER");
        String msg = "";
        msg = parser.parse();
        System.out.println(msg);



        System.out.println("************************************");
        parserFactory = ParserFactoryProducer.getFactory("LondonFactory");
        //parser = parserFactory.getParserInstance("LondonFEEDBACK");
        parser = parserFactory.getParserInstance("FEEDBACK");
        msg = parser.parse();
        System.out.println(msg);
    }
}
