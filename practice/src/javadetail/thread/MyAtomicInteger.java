package javadetail.thread;

/**
 * 实现atomicInteger的原子增和原子减操作,CAS(compare and swap) 乐观锁的概念
 *
 * CAS->AQS->ReentrantLock->Lock
 */
public class MyAtomicInteger {
    private volatile int value;

    public MyAtomicInteger(int value) {
        this.value = value;
    }

    public final int get() {
        return this.value;
    }

    public final void set(int newOne) {
        this.value = newOne;
    }

    public final int getAndSet(int newOne) {
        for (;;) {
            int cur = get();
            if (compareAndSwap(cur, newOne)) {
                return cur;
            }
        }
    }
    public final int getAndIncrement() {
        for(;;) {
            int cur = get();
            int next = cur + 1;
            if (compareAndSwap(cur, next)) {
                return cur;
            }
        }
    }

    public final int getAndDecrement() {
        for(;;) {
            int cur = get();
            int next = cur - 1;
            if (compareAndSwap(cur, next)) {
                return cur;
            }
        }
    }

    public final boolean compareAndSwap(int expected, int next) {
        int cur = get();
        if (cur == expected) {
            set(next);
            return true;
        } else {
            return false;
        }
    }
}
