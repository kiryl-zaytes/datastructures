package problems.array;

/**
 * Created by kiryl_zayets on 9/9/18.
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;

        int l = digits.length - 1;

        if (digits[l] != 9) {
            digits[l] += 1;
            return digits;
        } else {
            while (digits[l] == 9 && (l > 0)) {
                digits[l] = 0;
                l--;
            }
            digits[l] = digits[l] + 1;

            if (l == 0 && (digits[l] == 10)){
                int[] copy = new int[digits.length+1];
                copy[0] = 1;
                return copy;
            }
        }

        return digits;
    }


    public static void main(String[] args) {
        int[] r = PlusOne.plusOne(new int[]{8, 9, 9, 9});
        System.out.println("ll");
    }

}
