package problems.array;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by kiryl_zayets on 10/23/18.
 */
public class IntersectionTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {


        HashSet<Integer> storage = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        int[] arr;

        for (int i = 0; i < nums1.length; i++) {
            storage.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (storage.contains(nums2[j])){
                storage.remove(nums2[j]);
                res.add(nums2[j]);
            }
        }


        arr = new int[res.size()];
        for (int n =0; n < res.size(); n++){
            arr[n] = res.get(n);
        }

        return arr;
    }

    public static void main(String[] args){
        IntersectionTwoArrays i2r = new IntersectionTwoArrays();
        i2r.intersection(new int[]{}, new int[]{});
    }


}
