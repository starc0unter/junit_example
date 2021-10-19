package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public final class MyTestRule implements TestRule {

    @Override
    public @NotNull Statement apply(@NotNull Statement base, @NotNull Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                System.out.println("before");
                base.evaluate();
                System.out.println("after");
            }
        };
    }
}
