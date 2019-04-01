package problems.other;

/**
 * Created by kiryl_zayets on 9/19/18.
 */
public class MissingNumber {


    public static int missingNumber1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1 && nums[0] == 0) return ++nums[0];
        else if (nums.length == 1) return --nums[0];

        int max = 0;
        int total = 0;
        int found = 0;
        boolean hasZero = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] == 0) hasZero = true;
            total += nums[i];
        }

        int j = 0;

        while (j <= max) {
            found += j;
            j++;
        }

        if (found == total && hasZero) return max + 1;
        else if (found == total && !hasZero) return 0;
        return found - total;

    }

    public static int missingNumber(int[] nums) {

        for(int i=0; i < nums.length; i++){
            if (i == nums[i]) continue;
            int next = nums[i];
            while(next < nums.length && next != nums[next]){
                if(nums[next] >= nums.length){
                    nums[next] = next;
                    break;
                }
                int b = nums[next];
                nums[next] = next;
                next = b;
            }
        }

        for(int i=0; i < nums.length; i++){
            if (i != nums[i]) return i;
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.print(MissingNumber.missingNumber(new int[]{1,0,3}));
    }

}
