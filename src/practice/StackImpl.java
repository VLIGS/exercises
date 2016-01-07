package practice;

import java.util.ArrayList;
import java.util.List;

public class StackImpl <E>implements Stack <E>{
    private final List <E> list = new ArrayList<E>();
    @Override
    public void push(E item){
        list.add(0,item);

    }
    @Override
    public E pop(){
        if(list.isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty - can't pop");
        return list.remove(0);
    }
}
