import org.algorithms.CyclicBarrier;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.*;

public class CyclicBarrierTest {

    @Test
    void CyclicBarrierSampleWorkflow() {
        CyclicBarrier barrier = new CyclicBarrier(3);
        AtomicBoolean marker = new AtomicBoolean(false);
        Runnable sampleJob = () -> {
            try {
                barrier.await();
                marker.set(true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        try {
            new Thread(sampleJob).start();
            sleep(10);
            assertFalse(marker.get());
            new Thread(sampleJob).start();
            sleep(10);
            assertFalse(marker.get());
            new Thread(sampleJob).start();
            sleep(10);
            assertTrue(marker.get());
        } catch (InterruptedException e) {
            fail("Exception in the test case");
        }
    }
}
