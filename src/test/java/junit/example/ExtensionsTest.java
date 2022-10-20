package junit.example;

import junit.example.extensions.ConditionalExtension;
import junit.example.extensions.MyExtension;
import junit.example.extensions.Watcher;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

@SuppressWarnings({"MissortedModifiers", "UseOfSystemOutOrSystemErr"})
@ExtendWith(ConditionalExtension.class)
public final class ExtensionsTest {

    @Order(0)
    @RegisterExtension
    private static final @NotNull MyExtension extension = new MyExtension();
    @Order(1)
    @RegisterExtension
    private static final @NotNull Watcher watcher = new Watcher();


    @AfterAll
    public static void printFailedTests() {
        System.out.println("Tests failed: ");
        watcher.failedTests().forEach(System.out::println);
    }

    @Test
    public void throwsNullPointerExceptionWithMessage() {
        extension.assertStatus(1);
    }

    @Test
    public void willFail() {
        Assertions.fail();
    }

    @Test
    public void omittedTest() {
        Assertions.fail();
    }

    @DisplayName("OkNameTest")
    @Disabled
    public void strangeNameTest() {

    }

    @Test
    public void test1() {
        System.out.println("@Test - test_1");
    }

    @Test
    public void test2() {
        System.out.println("@Test - test_2");
    }
}
