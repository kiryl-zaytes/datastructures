package problems.array;

/**
 * Created by kiryl_zayets on 11/13/18.
 */
public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {

        int l = 0;
        for (int e : nums) {
            if (l < 2 || nums[l - 2] < e) {
                nums[l] = e;
                l++;
            }
        }
        return l;
    }



    public static void main(String[] args) {
        RemoveDuplicatesSortedArray rd = new RemoveDuplicatesSortedArray();
        rd.removeDuplicates(new int[]{1, 1, 1, 1, 1, 1, 1, 3,});
    }

}
