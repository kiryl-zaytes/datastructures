package problems.array;

import java.util.Arrays;

/**
 * 1. Sort array and calculate maximum possible absolute diff (last val of array - first). Difference going forward can be greater than that value.
 2. Use binary search to cut abs diff at halves as usual (not array but diff), and check how many values in array less or equal to current diff.
 3. To count those val you dont need to pass through array again and again. What you need is to make first scan with lowest i agains each j. Each time when a[i] -a[j] >= m add 1 to j and keep it where it is, dont skip it 0 again. As your array is sorted and next i will be greater than prev diff between this i and j could be only greater but not less than prev so we check if j could get further and automatically count all values
 between i and j (j-i-1);
 4. Check if the count < k and go righ side, else go left.
 5. Return lowest index when it is done.
 */
public class FindKthSmallestDistance {

    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);

        int l = 0;
        int n = nums.length;
        int h = nums[n - 1];
        while (l < h) {
            int m = l + (h - l) / 2;
            int count = 0;
            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= m) j++;
                count += j - i - 1;
            }
            if (count < k) l=m+1;
            else h=m;
        }
        return l;

    }

    public static void main(String[] args){
        FindKthSmallestDistance fksm = new FindKthSmallestDistance();
        System.out.print(fksm.smallestDistancePair(new int[]{1, 6, 1}, 3));
    }

}
