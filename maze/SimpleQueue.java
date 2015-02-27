import java.util.*;

public class SimpleQueue<T> {
    protected LinkedList<T> queue;
    public SimpleQueue(){
        queue = new LinkedList<T>();
    }

    public T enQueue(T x){
        queue.addLast(x);
        return x;
    }

    public T deQueue(){
        if(queue.isEmpty())
            return null;
        T y = queue.poll();
        return y;
    }

    public boolean isEmpty(){
        if(queue.isEmpty())
            return true;
        else
            return false;
    }
}
