package problems.array;

/**
 * Created by kiryl_zayets on 2/12/19.
 */
public class NextPermutation {

    int[] nums = null;

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;

        this.nums = nums;

        int i = nums.length - 1;

        while (i > 0){
            if ( nums[i-1] < nums[i]) break;
            i--;
        }

        if (i == 0) {
            reverse(i, nums.length-1);
            return;
        }
        else {
            int j = nums.length - 1;
            while (j >= i){
                if (nums[j] > nums[i-1]) break;
                j--;
            }

            swap(i-1, j);
            reverse(i, nums.length-1);
        }


    }

    private void reverse(int i, int j){
        while(i < j) swap(i++, j--);
    }

    private void swap(int i, int j){
        int b = nums[i];
        nums[i] = nums[j];
        nums[j] = b;
    }


    public static void main(String[] args){
        NextPermutation np = new NextPermutation();
        np.nextPermutation(new int[]{1,3,2});
    }

}
