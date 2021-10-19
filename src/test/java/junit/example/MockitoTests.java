package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Collections;

public final class MockitoTests {

    @Mock
    private @NotNull
    DataService service;


    @Spy
    private @NotNull
    Calculator calculator = new Calculator();


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
}
