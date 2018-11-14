package problems.array;

/**
 * Good solution is to keep two pointers one is storing position where to put unique
 * num and the other one is looking ahead to find next unique num in array.
 * When previous not equal next event occurs you need to rewrite slow index position and increment.
 * If there is no duplicates you should rewrite current position with same num to move forward.
 * Stop when fast index reaches the end of array.
 */
public class RemoveDuplicates {

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 1) return 1;
        int l = 0;
        int h = 0;
        while (h < nums.length){
            if ( h==0 || (nums[h] != nums[h-1])){
                nums[l] = nums[h];
                l++;
            }
            h++;
        }
        return l;
    }

    public static void main(String[] args) {
        int res = removeDuplicates1(new int[]{1, 1, 2, 2, 3, 3, 3, 3, 4, 5});
        System.out.print(res);
    }

}
