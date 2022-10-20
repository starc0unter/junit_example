package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;

public final class SessionTest {
    @Mock
    @NotNull
    private DataService dataService;

    @NotNull
    private MockitoSession session;

    @BeforeEach
    public void beforeMethod() {
        session = Mockito.mockitoSession()
                .initMocks(this)
                .startMocking();
    }

    @Test
    public void testMethod() {
        // some code using the dataService field
    }

    @AfterEach
    public void afterMethod() {
        session.finishMocking();
    }
}
