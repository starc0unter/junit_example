package junit.example;

import org.junit.Test;

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
    }
}
