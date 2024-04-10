/**
 * Created by tomasz_taw
 * Date: 10.04.2024
 * Time: 16:32
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.fizzBuzz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FizzBuzzImpl implements FizzBuzz {

    @Override
    public List<String> convert(List<Integer> numbers) {
        if (numbers == null) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();

        for (Integer number : numbers) {
            if (number == null) {
                return Collections.emptyList();
            } else if (number % 15 == 0) {
                result.add("FizzBuzz");
            } else if (number % 5 == 0) {
                result.add("Buzz");
            } else if (number % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(number.toString());
            }
        }

        return result;
    }

    public List<String> convertWithStringConcat(List<Integer> numbers) {
        if (numbers == null) {
            return Collections.emptyList();
        }
        if (numbers.getFirst() == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();

        for (Integer number : numbers) {
            String str = "";

            if (number % 3 == 0) {
                str += "Fizz";
            }
            if (number % 5 == 0) {
                str += "Buzz";
            }
            if (str.isBlank()) {
                str += number;
            }

            result.add(str);
        }

        return result;
    }

    // switch i stream

}
