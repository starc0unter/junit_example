package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.startsWith;

public final class RulesTest {

    @ClassRule
    public static final @NotNull
    MyTestRule rule = new MyTestRule();
    @Rule
    public @NotNull
    ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsNullPointerExceptionWithMessage() {
        thrown.expectMessage("happened?");
        thrown.expectMessage(startsWith("What"));
        throw new NullPointerException("What happened?");
    }

    @Test
    public void test_1() {
        System.out.println("@Test - tes_1");
    }

    @Test
    public void test_2() {
        System.out.println("@Test - test_2");
    }
}
