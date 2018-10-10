package problems.array;

/**
 * Take first as start point and increment and decrement counter whe it is equal or not to next item in array.
 * As majority is always > than half of array at the end I will be left with answer.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        int major = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) count++;
            else count--;

            if (count == 0) {
                major = nums[i];
                count++;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();

        majorityElement.majorityElement(new int[]{2,2,1,1,1,2,2});
    }


}
