package junit.example.extensions;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.*;

public final class MyExtension implements BeforeEachCallback, BeforeAllCallback, AfterEachCallback, AfterAllCallback {
    private int status;

    @Override
    public void afterEach(@NotNull ExtensionContext context) throws Exception {
        status = -1;
        System.out.println("After each " + context.getTestMethod());
    }

    @Override
    public void beforeEach(@NotNull ExtensionContext context) throws Exception {
        status = 1;
        System.out.println("Before each " + context.getTestMethod());
    }

    @Override
    public void afterAll(@NotNull ExtensionContext context) throws Exception {
        status = -2;
        System.out.println("After all " + context.getExecutionMode());
    }

    @Override
    public void beforeAll(@NotNull ExtensionContext context) throws Exception {
        status = 2;
        System.out.println("Before all " + context.getRoot());
    }

    public void assertStatus(int expectedStatus) {
        Assertions.assertEquals(expectedStatus, status);
    }

}
