package problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 12/3/18.
 */
public class MissingNumbers {


    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i])-1;
            if (nums[val] > 0) nums[val] = - nums[val];
        }

        for(int j=0; j<nums.length; j++){
            if (nums[j] > 0 ) res.add(j+1);
        }
        return res;

    }


    public static void main(String[] args) {
        MissingNumbers ms = new MissingNumbers();
        ms.findDisappearedNumbers(new int[]{1,3,3,5,5,6,7,8});
    }
}
