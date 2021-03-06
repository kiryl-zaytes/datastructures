package problems.array;

/**
 * Created by kiryl_zayets on 10/2/18.
 */
public class SortColors {

    int[] nums;

    public void sortColors1(int[] nums) {
        this.nums = nums;
        int l = 0;
        int h = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) swap(l++, i);
            if (nums[i] == 2 && i <= h) swap(h--, i--);
        }

    }

    public void swap(int i, int j) {
        int v = nums[i];
        nums[i] = nums[j];
        nums[j] = v;

    }


    public void sortColors(int[] nums) {

        int l = 0;
        int h = nums.length-1;


        for(int i=0; i< nums.length; i++){
            if (nums[l] == 0) {
                l++;
                continue;
            }
            if (nums[h] == 2) {
                h--;
                continue;
            }

            int b = nums[l];
            nums[l] = nums[h];
            nums[h] = b;
        }
    }


    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[]{2,0,2,1,1,0});


    }

}
