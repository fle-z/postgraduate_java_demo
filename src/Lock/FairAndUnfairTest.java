package Lock;

import org.junit.Test;
import util.SleepUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairTest {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    @Test
    public void fair() {
        testLock(fairLock);
    }

    @Test
    public void unfair() {
        testLock(unfairLock);
    }

    private void testLock(Lock lock) {
        for(int i = 0; i < 5; i++) {
            Job j = new Job(lock);
            j.setName("" + i);
            j.start();
        }
        SleepUtils.second(15);
    }

    private static class Job extends Thread {
        private Lock lock;
        public Job(Lock lock) {
            this.lock = lock;
        }

        public void run() {
            for(int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    SleepUtils.second(1);
                    System.out.println("获取锁的当前线程[" + Thread.currentThread().getName() + "], " +
                            "同步队列中的线程" + ((ReentrantLock2)lock).getQueuedThreads() + "");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
