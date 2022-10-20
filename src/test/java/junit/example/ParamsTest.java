package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SuppressWarnings({"NotNullNullableValidation", "MagicNumber", "MissortedModifiers"})
public final class ParamsTest {

    @ParameterizedTest
    @MethodSource("data")
    public void paramTest(@NotNull Params param) {
        assertEquals(param.expected, new Calculator().getSum(param.valueA, param.valueB));
    }

    private static @NotNull Collection<Params> data() {
        return Arrays.asList(
                new Params(1, 1, 2),
                new Params(2, 6, 8),
                new Params(18, 2, 20),
                new Params(13, 153, 28)
        );
    }

    private record Params(int valueA, int valueB, int expected) {
    }
}
