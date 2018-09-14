package problems.array;

/**
 * Created by kiryl_zayets on 9/13/18.
 */
public class MergeSorted {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m==0) nums1[0] = nums2[0];
        if (n==0) return;

        int i = m - 1;
        int j = n - 1;
        int k = nums1.length -1;

        while (i >= 0 && j >=0) {

            if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];

        }

        while (j >= 0) nums1[k--] = nums2[j--];


    }


    public static void main(String[] args) {
        MergeSorted.merge(new int[]{2,0}, 1, new int[]{1},
                1);
    }

}
