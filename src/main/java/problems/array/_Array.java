package problems.array;

import java.util.Arrays;

/**
 * * Basic array manipulations
 */
public class _Array {

    public _Array() {
    }

    public static double findMax(int[] arr) {
        double m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > m) m = arr[i];
        }
        return m;
    }

    /**
     * Dont forget subtract -1 as array starts form 0 index.
     */
    public static int[] reverse(int arr[]) {
        int b;
        for (int i = 0; i < arr.length / 2; i++) {
            b = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = b;
        }
        return arr;
    }


    /**
     * Square matrices!
     * Third cycle to keep track each element from ith row multiply to jth
     * column.
     * k - number of elements as matrix is square it is equal (product
     * row*column)
     */
    public static int[][] dotProduct(int[][] a, int[][] b) {
        int l = a.length;
        int[][] c = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                for (int k = 0; k < l; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    /**
     * Pay attention to how recursion works: once value find you need to
     * return it to the very top of stack.
     */
    public static int binarySearch(int[] arr, int n, int low, int high) {
        if (low > high) return -1;
        int m = low + (high - low) / 2;

        if (n > arr[m]) {
            return binarySearch(arr, n, m + 1, high);
        } else if (n < arr[m]) {
            return binarySearch(arr, n, low, m - 1);
        }

        return arr[m];
    }


    /**
     *Template #1 is the most basic and elementary form of Binary Search.
     *  Initial Condition: left = 0, right = length-1
        Termination: left > right
        Searching Left: right = mid-1
        Searching Right: left = mid+1
     */
    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while(left <= right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }
        return -1;
    }


    /**
     * Template #2 is an advanced form of Binary Search.
     * It is used to search for an element or condition which requires
     * accessing the current index and its immediate right neighbor's index in the array.
     * Initial Condition: left = 0, right = length
         Termination: left == right
         Searching Left: right = mid
         Searching Right: left = mid+1
     *
     */
    int binarySearch2(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while(left < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid; }
        }

        // Post-processing:
        // End Condition: left == right
        if(left != nums.length && nums[left] == target) return left;
        return -1;
    }



    /**
     // to avoid duplicates binarySearch could return rank instead of value. This
     // gives ability to check if rank < i if it is than that value has been
     // seen.
     // For ThreeSum0 pair a[i] and a[j] is part of a triple
     // thatsumsto0ifandonlyifthevalue-(a[i]+ a[j])isinthearray
     */

    public static int twoSum0(int[] a) {
        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (binarySearch(a, -a[i], 0, a.length) > -1) cnt++;
        }
        return cnt;
    }

    public static int threeSum0(int[] a) {
        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (binarySearch(a, -a[i] - a[j], 0, a.length-1) > -1) cnt++;
            }

        }
        return cnt;
    }



    public static void main(String[] args) {
        int[] a = new int[]{1, -1, 5, 10, 30, -30, -2, -3};
        int cnt = threeSum0(a);
        System.out.println(cnt);
    }

}
