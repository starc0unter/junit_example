package junit.example.guice;

import name.falgout.jeffrey.testing.junit.guice.GuiceExtension;
import name.falgout.jeffrey.testing.junit.guice.IncludeModule;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;

@ExtendWith(GuiceExtension.class)
@IncludeModule(TestModule.class)
public final class InjectedTests {

    @Inject
    @NotNull SomeInterface injected;

    @Test
    void someInterfaceHasBeenSuccessfullyInjected() {
        Assertions.assertEquals(123, injected.getValue());
    }

    @Test
    void anotherTest() {
        Assertions.assertEquals(111, injected.getValue());
    }

}
