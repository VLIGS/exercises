package strategy;

public class CapTextFormatter implements TextFormatter{
    public void format(String text){
        System.out.println(text.toUpperCase());
    }
}
