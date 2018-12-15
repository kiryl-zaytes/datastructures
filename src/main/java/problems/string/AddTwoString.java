package problems.string;

/**
 * Created by kiryl_zayets on 11/29/18.
 */
public class AddTwoString {

    public String addStrings(String num1, String num2) {
        if (num2.length() > num1.length()) return addStrings(num2, num1);

        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;

        int c1;
        int c2;

        int remainder = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = n1; i >= 0; i--) {
            c1 = num1.charAt(i) - '0';
            c2 = (n2 >= 0) ? num2.charAt(n2) - '0' : 0;

            if (c1 + c2 + remainder >= 10) {
                sb.append((c1 + c2 + remainder) - 10);
                remainder = 1;
            } else {
                sb.append(c1 + c2 + remainder);
                remainder = 0;
            }
            n2--;
        }
        if (remainder > 0) sb.append(remainder);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddTwoString at = new AddTwoString();
        System.out.print(at.addStrings("0", "123"));

    }


}
