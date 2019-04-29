import java.util.*;
public class ThreadLocal<T> {
    private Map<Runnable, T> values = Collections.synchronizedMap(
            new HashMap<Runnable, T>()
    );

    public T get(){
        Thread curThread = Thread.currentThread();
        T o = values.get(curThread);
        if (o == null && !values.containsKey(curThread)){
            o = initialValue();
            values.put(curThread, o);
        }

        return o;
    }

    public void set(T newValue){
        values.put(Thread.currentThread(), newValue);
    }

    protected T initialValue(){
        return null;
    }
}
