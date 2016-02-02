package strategy;

//this is context for use of our strategies
public class TextEditor {
    private TextFormatter myFormatter;
    public TextEditor ( TextFormatter formatter){
        myFormatter = formatter;
    }
    public void publishText(String text){
        myFormatter.format(text);
    }
}

