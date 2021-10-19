package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class MainTest {
    private final @NotNull
    MainEntity entity = new MainEntity();

    @Test(expected = IllegalArgumentException.class)
    public void testThrowException() {
        double a = 10.5;
        double b = 0;
        double result = entity.devide(a, b);
    }

    @Test
    public void testThrowException2() {
        double a = 10.5;
        double b = 10.5;
        double expected = 12;
        assertEquals(expected, entity.devide(a, b), 100);
    }

    @Ignore("Тест ещё не реализован!!!")
    @Test(expected = IllegalArgumentException.class, timeout = 1000)
    public void testThrowException3() {
        double a = 10.5;
        double b = 10.5;
        double expected = 1;
        assertEquals(expected, entity.devide(a, b), 0);
    }

    @Test
    public void multiplicationOfZeroShouldReturnZero() {
        MainEntity tester = new MainEntity(); //класс содержащий статичный метод multiply(double, double)

        //тест будет провален при невыполнении любого из трех следующих утверждений
        assertEquals("1 x 0 должно быть 0", 0, tester.multiply(1, 0), 0.00001);
        assertEquals("0 x 1 должно быть 0", 0, tester.multiply(0, 1), 0.00001);
        assertEquals("0 x 0 должно быть 0", 0, tester.multiply(0, 0), 0.00001);
    }

    @Test
    public void someNewTest() {
        Assert.fail("test not implemented"); //автоматический провал теста
    }
}
