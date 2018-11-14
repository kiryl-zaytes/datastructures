package problems.array;

/**
 * Created by kiryl_zayets on 10/10/18.
 */
public class FindDupNumber {

    public int findDuplicate(int[] nums) {

        if (nums.length == 0) return 0;

        int l = 0;
        int h = nums.length - 1;


        while (l < h) {
            int m = l + (h - l) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= m) count++;
            }

            if (count <= m) l = m + 1;
            else h = m;

        }
        return l;
    }


    public static void main(String[] args) {
        FindDupNumber findDupNumber = new FindDupNumber();
        System.out.print(findDupNumber.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }


}
