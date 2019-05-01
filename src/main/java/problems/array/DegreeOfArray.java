package problems.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by kiryl_zayets on 4/3/19.
 */
public class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, LinkedList<Integer>> storage = new HashMap<>();
        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if (!storage.containsKey(nums[i])) storage.put(nums[i], new LinkedList<Integer>());
            storage.get(nums[i]).add(i);
            max = Math.max(storage.get(nums[i]).size(), max);
        }

        for(Map.Entry<Integer, LinkedList<Integer>> entry : storage.entrySet()){
            if(entry.getValue().size() == max) min = Math.min(entry.getValue().getLast() - entry.getValue().getFirst(), min);
        }
        return min + 1;

    }

    public static void main(String[] args){
        DegreeOfArray degreeOfArray = new DegreeOfArray();
        degreeOfArray.findShortestSubArray(new int[]{1,2,2,3,1,4,2});
    }

}
