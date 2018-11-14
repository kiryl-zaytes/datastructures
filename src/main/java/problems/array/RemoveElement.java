package problems.array;

/**
 * Created by kiryl_zayets on 11/13/18.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] == val) nums[l] = nums[r--];
            else l++;
        }

        return l;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        System.out.print(re.removeElement(new int[]{2}, 2));
    }

}
