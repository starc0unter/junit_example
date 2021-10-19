package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public final class ParamsTest {


    @SuppressWarnings("PublicField")
    @Parameterized.Parameter
    public @NotNull MyCustomParam param;

    @Parameterized.Parameters
    public static @NotNull
    Collection<MyCustomParam> dataForTest() {
        return Arrays.asList(
                new MyCustomParam(1, 1, 2),
                new MyCustomParam(2, 6, 8),
                new MyCustomParam(18, 2, 20),
                new MyCustomParam(13, 153, 28)
        );
    }

    @Test
    public void paramTest() {
        assertEquals(param.expected, new Calculator().getSum(param.valueA, param.valueB));
    }

    private static final class MyCustomParam {
        public final int valueA;
        public final int valueB;
        public final int expected;

        public MyCustomParam(int valueA, int valueB, int expected) {
            this.valueA = valueA;
            this.valueB = valueB;
            this.expected = expected;
        }
    }
}
