package problems.array;

import java.util.*;

/**
 * Created by kiryl_zayets on 9/30/18.
 */
public class TopKFrequentEl {


    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        HashMap<Integer, List<Integer>> countNum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (numCount.containsKey(nums[i])) {
                Integer r = numCount.get(nums[i]);
                numCount.put(nums[i], ++r);
            } else numCount.put(nums[i], 1);
        }


        for (Map.Entry<Integer, Integer> e : numCount.entrySet()) {
            Integer n = e.getKey();
            Integer c = e.getValue();
            if (countNum.containsKey(c)) {
                List<Integer> l = countNum.get(c);
                l.add(n);
                countNum.put(c, l);
            } else countNum.put(c, new ArrayList<>(Arrays.asList(n)));
        }

        int maxDup = nums.length;
        ArrayList<Integer> res = new ArrayList<>();

        while (!countNum.containsKey(maxDup)) maxDup--;
        List s = countNum.get(maxDup);

        if (k <= s.size()) {
            while (k != 0) {
                res.add((Integer) s.remove(s.size() - 1));
                k--;
            }

        } else {
            while (k > 0) {
                if (countNum.containsKey(maxDup)) {
                    List s1 = countNum.get(maxDup);
                    while (!s1.isEmpty() && k > 0){
                        res.add((Integer) s1.remove(s1.size() - 1));
                        k--;
                    }

                }
                maxDup--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentEl topKFrequentEl = new TopKFrequentEl();
        topKFrequentEl.topKFrequent(new int[]{1}, 1);
    }
}