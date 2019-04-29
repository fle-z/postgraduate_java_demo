final class Node {
    /**
     * 共享
     */
    static final Node SHARED = new Node();
    /**
     * 独占
     */
    static final Node EXCLUSIVE = null;
    /**
     * 因为超时或者中断，节点会被设置为取消状态，
     * 被取消的节点时不会参与到竞争中的，他会一直保持取消状态不会转变为其他状态；
     */
    static final int CANCELLED = 1;
    /**
     * 后继节点的线程处于等待状态，而当前节点的线程如果释放了同步状态或者被取消，
     * 将会通知后继节点，使后继节点的线程得以运行
     */
    static final int SIGNAL = -1;
    /**
     * 节点在等待队列中，节点线程等待在Condition上，当其他线程对Condition调用了signal()后，
     * 改节点将会从等待队列中转移到同步队列中，加入到同步状态的获取中
     */
    static final int CONDITION = -2;
    /**
     * 表示下一次共享式同步状态获取将会无条件地传播下去
     */
    static final int PROPAGATE = -3;
    /**
     * 等待状态
     */
    volatile int waitStatus;
    /**
     * 前驱节点
     */
    volatile Node prev;
    /**
     * 后继节点
     */
    volatile Node next;
    /**
     * 获取同步状态的线程
     */
    volatile Thread thread;
    Node nextWaiter;

    final boolean isShared() {
        return nextWaiter == SHARED;
    }

    final Node predecessor() throws NullPointerException {
        Node p = prev;
        if (p == null) throw new NullPointerException();
        else return p;
    }

    Node() {
    }

    Node(Thread thread, Node mode) {
        this.nextWaiter = mode;
        this.thread = thread;
    }

    Node(Thread thread, int waitStatus) {
        this.waitStatus = waitStatus;
        this.thread = thread;
    }

}
