import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用LinkedHashMap实现简单的缓存， 必须实现removeEldestEntry方法
 * 如果 removeEldestEntry(Map.Entry<K,V> eldest) 方法返回值为 true 的时候，当我们添加一个新的元素之后，
 * afterNodeInsertion这个后置操作，将会删除双向链表最初的节点，也就是 head 节点。
 * @param <K>
 * @param <V>
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int maxCapacity;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;
    private final Lock lock = new ReentrantLock();

    private LRULinkedHashMap(int maxCapacity){
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
        return size() > maxCapacity;
    }

    public boolean containsKey(Object key){
        try {
            lock.lock();
            return super.containsKey(key);
        } finally {
            lock.unlock();
        }
    }

    public V get(Object key){
        try {
            lock.lock();
            return super.get(key);
        } finally {
            lock.unlock();
        }
    }

    public V put(K key, V value){
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public int size(){
        try {
            lock.lock();
            return super.size();
        } finally {
            lock.unlock();
        }
    }

    public void clear(){
        try {
            lock.lock();
            super.clear();
        } finally {
            lock.unlock();
        }
    }

    public Collection<Map.Entry<K, V>> getAll() {
        try {
            lock.lock();
            return new ArrayList<Map.Entry<K, V>>(super.entrySet());
        } finally {
            lock.unlock();
        }
    }
}
