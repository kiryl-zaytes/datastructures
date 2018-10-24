package problems.array;

/**
 * Created by kiryl_zayets on 10/18/18.
 */
public class FindMinimumRotatedArray {

    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        return helper(0, nums.length - 1, nums, Integer.MAX_VALUE);
    }


    private int helper(int l, int h, int[] input, int min) {
        if (l > h) return min;
        int m = l + (h-l)/2;
        if (input[l] <= input[m]){
            if (input[l] < min) min = input[l];
            return helper(m+1, h, input, min);
        }
        else {
            if (min > input[m]) min = input[m];
            return helper(l, m-1, input, min);
        }
    }

    public static void main(String[] args){
        FindMinimumRotatedArray fmr = new FindMinimumRotatedArray();

        System.out.print(fmr.findMin(new int[]{3, 4, 5, 6, 7, 0, 1, 2, 10}));
    }

}
