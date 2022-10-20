package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@SuppressWarnings({"MagicNumber", "InfiniteLoopStatement"})
public final class MainTest {
    @NotNull
    private final MainEntity entity = new MainEntity();

    @BeforeAll
    public static void beforeAll() {
        //запустится перед всеми тестами
    }

    @AfterAll
    public static void afterAll() {
        //запустится после всех тестов
    }

    @BeforeEach
    public void beforeEach() {
        //запустится перед каждым тестом
    }

    @AfterEach
    public void afterEach() {
        //запустится после каждого теста
    }

    @Test
    public void testMethod() {
        assertSame("expected", "actual");      //проверяет на равенство объекты
        assertNotSame("expected", "actual"); //Same наоборот
        assertEquals(1, 0, () -> "error");     //проверяет на равенство int, в случае фейла - текст
        assertEquals(1.1, 0f);                 //проверяет на равенство double
        assertAll("Должны выполниться все условия",
                () -> assertNull(null),                //проверяет на null
                () -> assertFalse(false)             //проверяет на false
        );
        //выставляем таймаут для чего-либо
        assertTimeout(Duration.of(10, ChronoUnit.SECONDS), () -> fail("явно фейлим тест"));
        //ожидаем появление исключения
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("two"));
    }

    @Test
    public void someNewTest() {
        Assertions.fail("test is not implemented"); //автоматический провал теста
    }

    @Test
    @Timeout(10)
    public void testThrowException() {
        final double a = 10.5;
        final double b = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> entity.divide(a, b));
    }

    @Disabled("Тест ещё не реализован!!!")
    @Test
    @Tag("flaky")
    @Timeout(value = 34, unit = TimeUnit.SECONDS, threadMode = Timeout.ThreadMode.SAME_THREAD)
    public void testThrowException3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> mayThrowException());
    }

    @Test
    @Timeout(value = 10)
    public void willNeverFail() {
        while (true) {
        }
    }

    @Test
    public void multiplicationOfZeroShouldReturnZero() {
        final var tester = new MainEntity(); //класс содержащий статичный метод multiply(double, double)

        //тест будет провален при невыполнении любого из трех следующих утверждений
        assertEquals(0, tester.multiply(1, 0));
        assertEquals(0, tester.multiply(0, 1));
        assertEquals(0, tester.multiply(0, 0));
    }

    @Test
    void canCorrectlyWriteToTempDir(@NotNull @TempDir Path tempDir) throws IOException {
        final var numbers = tempDir.resolve("text.txt");
        final var lines = List.of("здесь", "какой-то", "текст");
        Files.write(numbers, lines);

        assertAll(
                () -> assertTrue(Files.exists(numbers), () -> "Файл не существует"),
                () -> assertLinesMatch(lines, Files.readAllLines(numbers))
        );
    }

    private void mayThrowException() {
        final double a = 10.5;
        final double b = 10.5;
        final double expected = 1;
        assertEquals(expected, entity.divide(a, b), 0);
    }

}
