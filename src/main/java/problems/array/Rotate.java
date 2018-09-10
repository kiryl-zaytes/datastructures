package problems.array;

/**
 * Created by kiryl_zayets on 9/7/18.
 */
public class Rotate {

    public static int[] rotate(int[] nums, int k) {
        if (k >= nums.length) k = k - nums.length;
        if ((nums.length < 2) || (k == 0)) {
            return nums;
        }

        int rotationPoint = nums.length - k;
        int l = 0;
        int h = nums.length - 1;
        int buff = 0;

        int m = l + (rotationPoint - l) / 2;

        while (l < m) {
            buff = nums[l];
            nums[l] = nums[rotationPoint - l - 1];
            nums[rotationPoint - l - 1] = buff;
            l++;
        }

        m = rotationPoint + (h - rotationPoint) / 2;
        l = rotationPoint;

        while (h > m) {
            buff = nums[l];
            nums[l] = nums[h];
            nums[h] = buff;
            l++;
            h--;
        }


        l = 0;
        h = nums.length;
        m = l + (h-l) / 2;

        while (l < m) {
            buff = nums[l];
            nums[l++] = nums[--h];
            nums[h] = buff;
            //   l++;
            // h--;
        }

        return nums;
    }


    public static void main(String[] args) {
        int[] res = Rotate.rotate(new int[]{-1,-100,3,99}, 2);
        System.out.print(res);
    }

}
