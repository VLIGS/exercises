package strategy;

//this is concrete implementation of strategy
public class LowerTextFormatter implements TextFormatter{
    @Override
    public void format(String text){
        System.out.println(text.toLowerCase());
    }
}
