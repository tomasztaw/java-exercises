/**
 * Created by tomasz_taw
 * Date: 10.04.2024
 * Time: 16:30
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.fizzBuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FizzBuzzImplTest {

    @Test
    void shouldReturnFizzIfListContainOneElement_3() {
        // given
        FizzBuzz fizzBuzz = new FizzBuzzImpl();

        // when
        List<String> result = fizzBuzz.convert(List.of(3));

        // then
        Assertions.assertEquals("Fizz", result.getFirst());
    }

    @Test
    void shouldReturnBuzzIfListContainOneElement_5() {
        // given
        FizzBuzz fizzBuzz = new FizzBuzzImpl();

        // when
        List<String> result = fizzBuzz.convert(List.of(5));

        // then
        Assertions.assertEquals("Buzz", result.getFirst());
    }

    @Test
    void shouldReturnFizzBuzzIfListContainOneElement_15() {
        // given
        FizzBuzz fizzBuzz = new FizzBuzzImpl();

        // when
        List<String> result = fizzBuzz.convert(List.of(15));

        // then
        Assertions.assertEquals("FizzBuzz", result.getFirst());
    }

    @Test
    void shouldReturn1IfListContainOneElement_1() {
        // given
        FizzBuzz fizzBuzz = new FizzBuzzImpl();

        // when
        List<String> result = fizzBuzz.convert(List.of(1));

        // then
        Assertions.assertEquals("1", result.getFirst());
    }

    @Test
    void shouldReturn1FizzBuzzIfListContainElements_1_3_5_15() {
        // given
        FizzBuzz fizzBuzz = new FizzBuzzImpl();

        // when
        List<String> result = fizzBuzz.convert(List.of(1, 3, 5, 15));

        // then
        Assertions.assertEquals("1", result.getFirst());
        Assertions.assertEquals("Fizz", result.get(1));
        Assertions.assertEquals("Buzz", result.get(2));
        Assertions.assertEquals("FizzBuzz", result.getLast());
    }

    @Test
    void shouldReturnEmptyListIfListIsNull() {
        // given
        FizzBuzz fizzBuzz = new FizzBuzzImpl();

        // when
        List<String> result = fizzBuzz.convert(null);

        // then
        Assertions.assertEquals(0, result.size());
        Assertions.assertEquals(Collections.emptyList(), result);
    }

    @Test
    void shouldReturnEmptyListIfListContainsNull() {
        // given
        FizzBuzz fizzBuzz = new FizzBuzzImpl();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(null);

        // when
        List<String> result = fizzBuzz.convert(numbers);

        // then
        Assertions.assertEquals(0, result.size());
        Assertions.assertEquals(Collections.emptyList(), result);
    }

    // String concat
    @Test
    void shouldReturn1FizzBuzzIfListContainElements_1_3_5_15StringConcat() {
        // given
        FizzBuzzImpl fizzBuzz = new FizzBuzzImpl();

        // when
        List<String> result = fizzBuzz.convertWithStringConcat(List.of(1, 3, 5, 15));

        // then
        Assertions.assertEquals("1", result.getFirst());
        Assertions.assertEquals("Fizz", result.get(1));
        Assertions.assertEquals("Buzz", result.get(2));
        Assertions.assertEquals("FizzBuzz", result.getLast());
    }


}
