package junit.example.extensions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings({"NotNullNullableValidation", "MissortedModifiers"})
public final class Watcher implements TestWatcher {
    private final @NotNull List<String> failedTests = new ArrayList<>();

    @Override
    public void testDisabled(@NotNull ExtensionContext context, @NotNull Optional<String> reason) {
        System.out.println("Test " + context.getDisplayName() + " is disabled because of " + reason.orElse(""));
    }

    @Override
    public void testSuccessful(@NotNull ExtensionContext context) {
        System.out.println("Test " + context.getDisplayName() + " has passed");
    }

    @Override
    public void testAborted(@NotNull ExtensionContext context, @Nullable Throwable cause) {
        System.out.println("Test abortion due to " + cause);
    }

    @Override
    public void testFailed(@NotNull ExtensionContext context, @Nullable Throwable cause) {
        failedTests.add(context.getDisplayName());
    }

    public @NotNull List<String> failedTests() {
        return new ArrayList<>(failedTests);
    }
}
