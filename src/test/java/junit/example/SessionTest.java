package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;

public final class SessionTest {
    @Mock
    @NotNull
    private DataService dataService;

    @NotNull
    private MockitoSession session;

    @Before
    public void beforeMethod() {
        session = Mockito.mockitoSession()
                .initMocks(this)
                .startMocking();
    }

    @Test
    public void testMethod() {
        // some code using the dataService field
    }

    @After
    public void afterMethod() {
        session.finishMocking();
    }
}
