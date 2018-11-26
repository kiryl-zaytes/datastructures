package problems.string;

/**
 * Created by kiryl_zayets on 11/22/18.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int c = x;
        long res = 0;
        if (x < 0) return false;
        while (x >= 10) {
            res += x % 10;
            res *= 10;
            x = x / 10;
        }
        res += x;
        return res == c;
    }


    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.print(pn.isPalindrome(1));
    }
}
