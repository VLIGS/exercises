package strategy;

public class LowerTextFormatter implements TextFormatter{
    public void format(String text){
        System.out.println(text.toLowerCase());
    }
}
