package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public final class MockSpyTest {
    @Mock
    private @NotNull List<String> mockList;

    @Spy
    private @NotNull List<String> spyList = new ArrayList();

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
        //spy-объект вызовет реальным метод, который не был переопределен
        spyList.add("test");

        Mockito.verify(spyList).add("test");
        assertEquals(1, spyList.size());
        assertEquals("test", spyList.get(0));
    }

    @After
    public void after() {
        Mockito.reset();
    }
}
