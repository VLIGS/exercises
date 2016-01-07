package practice;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackImpl<Integer>();
        stack.push(3);
        stack.push(4);
        stack.push(1);
        Stack<String > myString = new StackImpl<String>();
        myString.push("noooo");
        String mySingleString = myString.pop();
    }
}
