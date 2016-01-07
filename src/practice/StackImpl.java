package practice;

import java.util.ArrayList;
import java.util.List;

public class StackImpl implements Stack{
    private final List list = new ArrayList();
    @Override
    public void push(int item){
        list.add(0,item);

    }
    @Override
    public int pop(){
        if(list.isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty - can't pop");
        return (Integer)list.remove(0);
    }
}
