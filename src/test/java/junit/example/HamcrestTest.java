package junit.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public final class HamcrestTest {
    @Test
    public void givenNumber_whenConditions_thenCorrect() {
        final var intVal = 7;
        assertThat(intVal, allOf(greaterThan(5), lessThanOrEqualTo(7), not(equalTo(6))));
    }

    @Test
    public void givenNumber() {
        final var intVal = 7;
        assertThat(intVal, is(7));
        assertThat(intVal, is(not(2)));
    }

    @Test
    public void listIsNotEmpty() {
        final var list = List.of(5, 2, 4);
        assertThat(list, is(not(empty())));
    }

    @Test
    public void listHasOnlyPositiveElements() {
        final var list = List.of(5, 2, 4);
        assertThat(list, everyItem(greaterThan(0)));
    }

    @Test
    public void listHasItem() {
        final var list = List.of(5, 2, 4);
        assertThat(list, hasItem(5));
    }

    @Test
    public void mapContainsRequiredData() {
        final var map = Map.of(1, "a", 2, "b", 3, "c");
        assertThat(map, hasKey(1));
        assertThat(map, hasValue("a"));
        assertThat(map, hasEntry(3, "c"));
    }

    @Test
    public void givenList() {
        final var list = List.of(1, 2, 3);
        assertThat(list, hasItem(3));
        assertThat(list, not(hasItem(5)));
    }

    @Test
    public void givenMap() {
        final var map = Map.of(
                1, "a",
                2, "b",
                3, "c"
        );

        assertThat(map, hasKey(1));
        assertThat(map, hasValue("b"));
        assertThat(map, hasEntry(3, "c"));
    }
}
