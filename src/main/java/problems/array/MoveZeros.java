package problems.array;

/**
 * Created by kiryl_zayets on 9/10/18.
 */
public class MoveZeros {

    public static void moveZeros(int[] nums) {

        if (nums.length < 2) return;

        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {

            if (nums[slow] != nums[fast]) {
                if (nums[slow] == 0) {
                    int b = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = b;
                }

                slow++;
            }
            fast++;
        }
    }

    public static void main(String[] args) {
        MoveZeros.moveZeros(new int[]{1, 0, 1, 0, 1, 1, 10, 0, 0, 12});
    }
}
