package problems.array;

/**
 * Partition each of array into to parts so in total we will have 4 imaginary arrays.
 * Take shorter one and divide it as usually with 2 halves. As median of two arrays its
 * a middle element for odd number of length and sum of two middle ones divided by two for
 * even length we needd to use formula to calculate parts os second array based on value of first.
 * (m+n+1)/2 - first.
 * Next set indexes for maxLeftX, minRighX for array 1 and same maxLeftY, minRightY for array 2.
 * Those will be our dividers.
 * If PartionX or Y equal to m or n accordingly that means no elements left in these parts and we assign -Infinity ot + Infinity.
 *
 * We need to find such position where maxLeftX <= minRightY and maxLeftY <= minRightX, if found the last thing we need to calculate is
 * whether length of our array even (sum of two mid elements , max from both left and min from both right) or odd(max from both left).
 *
 * If pos is not found proceed with binary search to left or right by setting low or high to partition+1 or -1.
 *
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int n = nums2.length;
        int m = nums1.length;
        int low = 0;
        int high = m;


        while (low <= high) {

            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[
                    partitionX - 1];

            int minRighX = (partitionX ==
                    m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[
                    partitionY - 1];
            int minRighY = (partitionY ==
                    n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRighY && maxLeftY <= minRighX) {

                if ((n + m) % 2 == 0)
                    return (double) (Math.max(maxLeftX, maxLeftY) +
                            Math.min(minRighX, minRighY)) / 2;

                else return (double) Math.max(maxLeftX, maxLeftY);
            } else {

                if (maxLeftX > minRighY) high = partitionX - 1;
                else low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args){

        MedianOfTwoSortedArrays mos = new MedianOfTwoSortedArrays();

        System.out.print(mos.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

    }

}
