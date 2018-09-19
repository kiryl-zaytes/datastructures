package problems.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 9/19/18.
 */
public class FizzBuzz {


    public static List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<String>();
        if (n < 0) return null;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) output.add("FizzBuzz");
            else if (i % 3 == 0) output.add("Fizz");
            else if (i % 5 == 0) output.add("Buzz");
            else output.add(String.valueOf(i));
        }
        return output;
    }

    public static void main(String[] args){

        FizzBuzz.fizzBuzz(15);

    }
}
