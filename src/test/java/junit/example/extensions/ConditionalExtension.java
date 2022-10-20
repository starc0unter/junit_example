package junit.example.extensions;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

@SuppressWarnings("MissortedModifiers")
public final class ConditionalExtension implements ExecutionCondition {

    @Override
    public @NotNull ConditionEvaluationResult evaluateExecutionCondition(@NotNull ExtensionContext context) {
        final var shouldDisableTest = context.getTestMethod().isPresent() && context.getTestMethod().get().getName().startsWith("omit");
        return shouldDisableTest
                ? ConditionEvaluationResult.disabled("should be omitted")
                : ConditionEvaluationResult.enabled("should run");
    }
}
