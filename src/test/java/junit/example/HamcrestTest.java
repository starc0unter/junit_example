package junit.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public final class HamcrestTest {

    @Test
    public void givenNumber_whenConditions_thenCorrect() {
        Integer intVal = 7;
        assertThat(intVal, allOf(greaterThan(5), lessThanOrEqualTo(7), not(equalTo(6))));
    }

    @Test
    public void givenNumber() {
        Integer intVal = 7;
        assertThat(intVal, is(7));
        assertThat(intVal, is(not(2)));
    }

    @Test
    public void givenList() {
        List<Integer> list = List.of(1, 2, 3);
        assertThat(list, hasItem(3));
        assertThat(list, not(hasItem(5)));
    }

    @Test
    public void givenMap() {
        Map<Integer, String> map = Map.of(1, "a", 2, "b", 3, "c");
        assertThat(map, hasKey(1));
        assertThat(map, hasValue("b"));
        assertThat(map, hasEntry(3, "c"));
    }
}
