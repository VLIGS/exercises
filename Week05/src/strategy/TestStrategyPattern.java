package strategy;

public class TestStrategyPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(new CapTextFormatter());
        editor.publishText("Testing text in caps formatter");
        editor = new TextEditor(new LowerTextFormatter());
        editor.publishText("Testing text in lower formatter");
    }
}