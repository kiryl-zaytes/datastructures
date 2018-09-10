package problems.array;

/**
 * Created by kiryl_zayets on 9/7/18.
 */
public class SingleNumber {
    public static int singleNumber(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.print(SingleNumber.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

}
