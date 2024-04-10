package pl.taw.fizzBuzz;

import java.util.List;

/**
 * Convert list of numbers to list of strings
 * With replacing:
 * divisibility by 3 = Fizz
 * divisibility by 5 = Buzz
 * divisibility by 15 = FizzBuzz
 */

public interface FizzBuzz {

    List<String> convert(List<Integer> numbers);

}
