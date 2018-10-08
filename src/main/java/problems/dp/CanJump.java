package problems.dp;

/**
 * Greedy technique, set first as max and then each step check if we could reach that position with
 * previous max value if so check once again if current pos + value > prev max val.
 * If max > array length return true.
 */
public class CanJump {


    public boolean canJump(int[] nums) {
        int maxJump = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxJump < i) return false;
            else if (maxJump >= nums.length - 1) return true;
            else if (nums[i] + i > maxJump) maxJump = nums[i] + i;
        }
        return true;

    }


    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.print(canJump.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
