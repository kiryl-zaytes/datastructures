package problems.dp;

/**
 * Three possible cases when use 1 array to store sequence.
 * 1. val less than first element - replace first element dont increment length.
 * 2. val greater than last element in seq - just add to the end and increment.
 * 3. val is in between somewhere in seq - find place and replace next element.
 * Use binary search to locate place in array. Search should return position where next el is
 * greater than one for insertion.
 * https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 */
public class LongestIncreasingSubsequence {

    private int binSearch(int[] a, int start, int end, int val){

        while ( end - start > 1){
            int m = start + (end - start)/2;

            if (a[m] >= val) end = m;
            else if (a[m] < val) start = m;
        }
        return end;

    }

    public int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length];
        int l = 1;
        sub[0] = nums[0];

        for(int i=1; i < nums.length; i++) {

            if (nums[i] <= sub[0]) sub[0] = nums[i];
            else if (nums[i] > sub[l-1]) sub[l++] = nums[i];
            else sub[binSearch(sub, 0, l, nums[i])] = nums[i];

        }
        return l;
    }

    public static void main(String[] args){
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        lis.lengthOfLIS(new int[]{4,10,4,3,8,9});
    }


}
