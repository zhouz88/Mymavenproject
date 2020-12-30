import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.mockito.Mockito.*;

public class MySampleTest {

    @Test
    public void test() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt()).thenReturn(100);  // 指定调用 nextInt 方法时，永远返回 100

        Assert.assertEquals(100, mockRandom.nextInt());
        Assert.assertEquals(100, mockRandom.nextInt());
    }
}