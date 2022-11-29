import org.algorithms.ReentrantLock;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.*;

public class ReentrantLockTest {
    @Test
    void ReentrantLockSingleThread() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        lock.lock();

        lock.unlock();
        lock.unlock();
        lock.unlock();
    }

    @Test
    void ReentrantLockLocksWithMultipleThreads() throws InterruptedException {
        AtomicBoolean marker = new AtomicBoolean(true);
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        new Thread(() -> {
            try {
                lock.lock();
                marker.set(false);
                lock.unlock();
            } catch (InterruptedException e) {
                fail("Exception in the test body");
            }
        }).start();

        sleep(5);
        assertTrue(marker.get());

        lock.unlock();
    }
}
