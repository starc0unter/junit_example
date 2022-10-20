package junit.example;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.internal.verification.AtLeast;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
@ExtendWith(MockitoExtension.class)
public final class MockitoTests {

    @Mock
    @NotNull
    private DataService service;

    @NotNull
    private MockitoSession session;

    @NotNull
    private Map<String, Integer> mapMock;

    @Test
    public void simpleMockTest() {
        final var mock = Mockito.mock(LinkedList.class);
        Mockito.when(mock.get(ArgumentMatchers.anyInt())).thenReturn(100);
        System.out.println(mock.get(2));       // консоль выведет "100"
    }

    @Test
    public void simpleSpyTest() {
        final var list = new LinkedList<String>();
        final var spy = Mockito.spy(list);

        //"переопределяем" метод size()
        Mockito.when(spy.size()).thenReturn(100);

        //используем реальные методы
        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0)); // консоль выведет "one"
        System.out.println(spy.size()); // консоль выведет "100"
    }

    @Test
    public void doAnswerExample() {
        mapMock = Mockito.mock(Map.class);
        Mockito.doAnswer(invocation -> 1).when(mapMock).get(ArgumentMatchers.anyString());
        System.out.println(mapMock.get("111"));
    }


    @Test
    public void testMock() {
        System.out.println(service.getData());
        System.out.println(service.getDataById(1));
        service.saveData(Collections.emptyList());
        service.saveData(Collections.emptyList());

        Mockito.verify(service).saveData(ArgumentMatchers.anyList());
    }

    @Test
    public void testMockVerifyCount() {
        System.out.println(service.getData());
        System.out.println(service.getDataById(1));

        service.saveData(Collections.emptyList());
        service.saveData(Collections.emptyList());

        Mockito.verify(service, Mockito.times(2)).saveData(ArgumentMatchers.anyList());
    }

    @Test
    public void testMockGetData() {
        Mockito.when(service.getData()).thenReturn(List.of("abc"));

        System.out.println(service.getData());
    }
}
