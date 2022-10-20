package junit.example;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SuppressWarnings({"NotNullNullableValidation", "MissortedModifiers"})
public final class MockSpyTest {
    @Mock
    private @NotNull List<String> mockList;

    @Spy
    private @NotNull List<String> spyList = new ArrayList<>();

    @NotNull
    private AutoCloseable mocks;

    @Test
    public void test() {
        //тут используем mockList и spyList
    }

    @BeforeEach
    public void before() {
        mocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void afterEach() throws Exception {
        mocks.close();
        Mockito.reset();
    }


    @Test
    public void testMockList() {
        //по умолчанию вызовы методов у mock-объектов ничего не будут делать
        mockList.add("test");

        Mockito.verify(mockList).add("test");
        assertEquals(0, mockList.size());
        assertNull(mockList.get(0));
    }

    @Test
    public void testSpyList() {
        //spy-объект вызовет реальный метод, который не был переопределен
        spyList.add("test");

        Mockito.verify(spyList).add("test");
        assertEquals(1, spyList.size());
        assertEquals("test", spyList.get(0));
    }

}
