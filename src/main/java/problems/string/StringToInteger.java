package problems.string;

/**
 * Created by kiryl_zayets on 9/11/18.
 */
public class StringToInteger {


    public static int myAtoi(String str) {
        if (str.length() == 0) return 0;
        int i = 0;
        long res = 0;
        int sign = 1;
        while (str.length() > i && str.charAt(i) == ' ') i++;

        if (str.length() > i &&
                (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = 1 - 2 * ((str.charAt(i) == '-') ? 1 : 0);
            i++;
        }

        while (i < str.length() &&
                (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {

            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 &&
                            str.charAt(i) - '0' > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            res = 10 * res + str.charAt(i) - '0';
            i++;
        }
        return sign * (int) res;

    }


    public static void main(String[] args) {
        System.out.print(StringToInteger.myAtoi("18446744073709551617"));
    }

}
