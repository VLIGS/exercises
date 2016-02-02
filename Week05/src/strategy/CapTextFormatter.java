package strategy;

//this is concrete implementation of strategy
public class CapTextFormatter implements TextFormatter{
    @Override
    public void format(String text){
        System.out.println(text.toUpperCase());
    }
}
