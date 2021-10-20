package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public final class MockitoTests {

    @Mock
    @NotNull
    private DataService service;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMock() {
        System.out.println(service.getData());
        System.out.println(service.getDataById(1));
        service.saveData(Collections.emptyList());
        service.saveData(Collections.emptyList());

        Mockito.verify(service).saveData(Mockito.anyList());
    }

    @Test
    public void testMockVerifyCount() {
        System.out.println(service.getData());
        System.out.println(service.getDataById(1));

        service.saveData(Collections.emptyList());
        service.saveData(Collections.emptyList());

        Mockito.verify(service, Mockito.times(2)).saveData(Mockito.anyList());
    }

    @Test
    public void testMockGetData() {
        Mockito.when(service.getData()).thenReturn(List.of("abc"));

        System.out.println(service.getData());
    }
}
