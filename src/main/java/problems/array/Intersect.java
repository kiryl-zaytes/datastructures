package problems.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kiryl_zayets on 9/7/18.
 */
public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if ((nums1.length < 1) || (nums2.length < 1)) return new int[]{};
        if (nums1.length == 1 && nums2.length == 1 && nums1[0] == nums2[0])
            return nums1;


        HashMap<Integer, Integer> storage = new HashMap<Integer, Integer>();
        int l = nums1.length;
        int l2 = nums2.length;
        int[] source;
        int[] lookup;
        if (l < l2) {
            source = nums1;
            lookup = nums2;
        } else {
            source = nums2;
            lookup = nums1;
        }

        ArrayList<Integer> intersection = new ArrayList<Integer>();

        for (int i = 0; i < source.length; i++) {
            if (!storage.containsKey(source[i])) storage.put(source[i], 1);
            else {
                Integer s = storage.get(source[i]);
                storage.put(source[i], ++s);
            }
        }

        for (int i = 0; i < lookup.length; i++) {
            if (storage.containsKey(lookup[i]) && storage.get(lookup[i]) > 1) {

                Integer tmp = storage.get(lookup[i]);
                intersection.add(lookup[i]);
                storage.put(lookup[i], --tmp);
            } else if (storage.containsKey(lookup[i])) {
                intersection.add(lookup[i]);
                storage.remove(lookup[i]);
            }
        }

        int[] resArray = new int[intersection.size()];
        for(int  i=0; i< resArray.length;i++){
            resArray[i] = intersection.get(i);
        }
        return resArray;
    }


    public static void main(String[] args) {
        Intersect.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }
}
