package problems.array;

/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the
 * elements of nums except nums[i]
 *
 * Use buffer array to keep track of product of sample numbers.
 * Move forward and produce product of samples up to that position.
 * Move backward to exclude current element from product and add elements from tail.
 *
 */
public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] sample) {
        if (sample.length < 1) return null;
        int[] buf = new int[sample.length];
        buf[0] = 1;

        for (int i = 1; i < sample.length; i++) {
            buf[i] = buf[i - 1] * sample[i - 1];
        }

        for (int j = sample.length - 1; j > 0; j--) {
            buf[j - 1] = buf[j - 1] * sample[j];
            sample[j - 1] *= sample[j];
        }
        return buf;
    }

    public static void main(String[] args) {
        int[] res = ProductExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.print(res);
    }

}
