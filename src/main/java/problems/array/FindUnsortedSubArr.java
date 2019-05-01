package problems.array;

/**
 * Created by kiryl_zayets on 4/1/19.
 */
public class FindUnsortedSubArr {

    public int findUnsortedSubarray(int[] nums) {

        if (nums.length == 1 || nums.length == 0) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i-1]) {
                min = Math.min(nums[i], min);
            }
        }

        for(int i=nums.length-1; i > 0; i--){
            if (nums[i] < nums[i-1]) {
                max = Math.max(nums[i-1], max);
            }
        }


        int l = 0;
        int h = nums.length-1;

        while(l < nums.length-1 && min >= nums[l]) l++;
        while(h > 0 && max <= nums[h]) h--;

        return h - l < 0 ? 0 : h - l + 1;

    }



    public static void main(String[] args){
        FindUnsortedSubArr fus = new FindUnsortedSubArr();
        fus.findUnsortedSubarray(new int[]{2,3,3,2,4});
    }

}
