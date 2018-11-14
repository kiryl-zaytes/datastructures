package problems.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kiryl_zayets on 11/14/18.
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> storage = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (storage.containsKey(nums[i])) {
                ArrayList<Integer> dist = storage.get(nums[i]);
                if (i - dist.get(dist.size() - 1) <= k) return true;
                else dist.add(i);
                storage.put(nums[i], dist);
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                storage.put(nums[i], l);
            }

        }
        return false;

    }

    public static void main(String[] args){
        ContainsDuplicateII c2= new ContainsDuplicateII();
        System.out.print(c2.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

}
