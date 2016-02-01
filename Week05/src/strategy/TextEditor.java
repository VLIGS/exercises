package strategy;

public class TextEditor {
    private TextFormatter myFormatter;
    public TextEditor ( TextFormatter formatter){
        myFormatter = formatter;
    }
    public void publishText(String text){
        myFormatter.format(text);
    }
}

