package problems.array;

import java.util.*;

/**
 * Created by kiryl_zayets on 12/21/18.
 */
public class TwoSumIII {

    Set<Integer> num;
    Set<Integer> sum;
    Map<Integer, Integer> num2;
    int lastVal = 0;

    /** Initialize your data structure here. */
    public TwoSumIII() {
        sum = new HashSet<>();
        num = new HashSet<>();
        num2 = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (num.contains(number)) sum.add(number * 2);
        else {
            Iterator<Integer> it = num.iterator();

            while (it.hasNext()){
                sum.add(it.next() + number);
            }
            num.add(number);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return sum.contains(value);
    }


    /** Add the number to an internal data structure.. */
    public void add1(int number) {
        num2.put(number, num2.getOrDefault(number, 0)+1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find1(int value) {
        Set<Integer> set = num2.keySet();
        for (Integer s : set){
            int target = value - s;
            if (num2.containsKey(target)){
                if (target != s || num2.getOrDefault(target, 0) >= 2) return true;
            }
        }
        return false;
    }

}
